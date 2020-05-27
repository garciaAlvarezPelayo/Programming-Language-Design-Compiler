grammar Cmm;	

@header{
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.main.*;
    import ast.statements.*;
    import ast.types.*;
}

program returns [Program ast]       :definitions main EOF
                                        {List<Definition> list = $definitions.ast;
                                            list.add($main.ast);
                                            $ast = new Program($definitions.start.getLine()
                                                                , $definitions.start.getCharPositionInLine()+1
                                                                , list);}
                                    ;

builtinType returns [Type ast]      :i='int'
                                       {$ast = new IntType($i.getLine()
                                                          , $i.getCharPositionInLine()+1);}
                                    |d='double'
                                       {$ast = new DoubleType($d.getLine()
                                                         , $d.getCharPositionInLine()+1);}
                                    |c='char'
                                       {$ast = new CharType($c.getLine()
                                                            , $c.getCharPositionInLine()+1);}
                                    ;

type returns [Type ast]             :builtinType
                                        {$ast = $builtinType.ast;}
                                    |ty=type '['INT_CONSTANT']'
                                        {$ast = new ArrayType($ty.start.getLine()
                                                             , $ty.start.getCharPositionInLine()+1
                                                             , $ty.ast
                                                             , LexerHelper.lexemeToInt($INT_CONSTANT.text)).UpdateArray();}
                                    |s='struct''{'records'}'
                                        {$ast = new StructType($s.getLine()
                                                              , $s.getCharPositionInLine()+1
                                                              , $records.ast);}
                                    ;

funcInv returns [FuncInv ast]       :ID
                                        {$ast = new FuncInv($ID.getLine()
                                                           , $ID.getCharPositionInLine()+1
                                                           , new Variable($ID.getLine()
                                                                         , $ID.getCharPositionInLine()+1
                                                                         , $ID.text)
                                                           , new ArrayList<Expression>());}
                                    '('(expressions
                                                    {$ast.setExpressions($expressions.ast);})?')'
                                    ;

expression returns [Expression ast] :'('ex=expression')'
                                        {$ast = $ex.ast;}
                                    |exp1=expression'['exp2=expression']'
                                        {$ast = new Indexing($exp1.start.getLine()
                                                            , $exp1.start.getCharPositionInLine()+1
                                                            , $exp1.ast
                                                            , $exp2.ast);}
                                    |funcInv
                                        {$ast = $funcInv.ast;}
                                    |ex=expression'.'ID
                                        {$ast = new FieldAccess($ex.start.getLine()
                                                                , $ex.start.getCharPositionInLine()+1
                                                                , $ID.text
                                                                , $ex.ast);}
                                    |'('builtinType')'ex=expression
                                        {$ast = new CastType($builtinType.start.getLine()
                                                            , $builtinType.start.getCharPositionInLine()+1
                                                            , $builtinType.ast
                                                            , $ex.ast);}
                                    |'-' ex=expression
                                        {$ast = new UnaryMinus($ex.start.getLine()
                                                              , $ex.start.getCharPositionInLine()+1
                                                              , $ex.ast);}
                                    |exp1=expression op=('*'|'/'|'%') exp2=expression
                                        {$ast = new AritmeticOperator($exp1.start.getLine()
                                                                     , $exp1.start.getCharPositionInLine()+1
                                                                     , $op.text
                                                                     , $exp1.ast
                                                                     , $exp2.ast);}
                                    |exp1=expression op=('+'|'-') exp2=expression
                                        {$ast = new AritmeticOperator($exp1.start.getLine()
                                                                     , $exp1.start.getCharPositionInLine()+1
                                                                     , $op.text
                                                                     , $exp1.ast
                                                                     , $exp2.ast);}
                                    |'!' ex=expression
                                        {$ast = new UnaryNegation($ex.start.getLine()
                                                                 , $ex.start.getCharPositionInLine()+1
                                                                 , $ex.ast);}
                                    |exp1=expression op=('>'|'>='|'<'|'<='|'!='|'==') exp2=expression
                                        {$ast = new LogicalComparator($exp1.start.getLine()
                                                                     , $exp1.start.getCharPositionInLine()+1
                                                                     , $op.text
                                                                     , $exp1.ast
                                                                     , $exp2.ast);}
                                    |exp1=expression op=('&&'|'||') exp2=expression
                                        {$ast = new LogicalDoor($exp1.start.getLine()
                                                               , $exp1.start.getCharPositionInLine()+1
                                                               , $op.text
                                                               , $exp1.ast
                                                               , $exp2.ast);}
                                    |ID
                                        {$ast = new Variable($ID.getLine()
                                                            , $ID.getCharPositionInLine()+1
                                                            , $ID.text);}
                                    |INT_CONSTANT
                                        {$ast = new IntLiteral($INT_CONSTANT.getLine()
                                                            , $INT_CONSTANT.getCharPositionInLine()+1
                                                            , LexerHelper.lexemeToInt($INT_CONSTANT.text));}
                                    |REAL_CONSTANT
                                        {$ast = new RealLiteral($REAL_CONSTANT.getLine()
                                                               , $REAL_CONSTANT.getCharPositionInLine()+1
                                                               , LexerHelper.lexemeToReal($REAL_CONSTANT.text));}
                                    |CHAR_CONSTANT
                                        {$ast = new CharacterLiteral($CHAR_CONSTANT.getLine()
                                                                    , $CHAR_CONSTANT.getCharPositionInLine()+1
                                                                    , LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
                                    ;

statement returns [List<Statement> ast = new ArrayList<Statement>()]
          locals [IfElse ifelse]                :
                                                exp1=expression op='='exp2=expression';'
                                                    {$ast.add(new Assigment($exp1.start.getLine()
                                                                            , $exp1.start.getCharPositionInLine()+1
                                                                            , $exp1.ast
                                                                            , $exp2.ast));}
                                                |'if''('expression')'b1=block
                                                    {$ifelse = new IfElse($expression.start.getLine()
                                                                        , $expression.start.getCharPositionInLine()+1
                                                                        , $expression.ast
                                                                        , $b1.ast);}
                                                ('else'b2=block
                                                    {$ifelse.setElse($b2.ast);})?
                                                        {$ast.add($ifelse);}
                                                |op=('read'|'write')expressions';'
                                                    {if($op.text.equals("read"))
                                                        for(Expression each : $expressions.ast)
                                                            $ast.add(new Read($op.getLine()
                                                                     , $op.getCharPositionInLine()+1
                                                                     , each));
                                                    else
                                                        for(Expression each : $expressions.ast)
                                                            $ast.add(new Write($op.getLine()
                                                                            , $op.getCharPositionInLine()+1
                                                                            , each));
                                                    }
                                                |r='return'expression';'
                                                    {$ast.add(new Return($r.getLine()
                                                                      , $r.getCharPositionInLine()+1
                                                                      , $expression.ast));}
                                                |w='while''('expression')'block
                                                    {$ast.add(new While($w.getLine()
                                                                     , $w.getCharPositionInLine()+1
                                                                     , $expression.ast
                                                                     , $block.ast));}
                                                |funcInv';'
                                                    {$ast.add($funcInv.ast);}
                                                |varDefinition';'
                                                    {$ast.addAll($varDefinition.ast);}
                                                ;

definition returns [List<Definition> ast = new ArrayList<Definition>()]             : (funcTypes) ID '('parameters')' '{'statements'}'
                                                                                        {$ast.add(new FuncDefinition($funcTypes.start.getLine()
                                                                                                                    , $funcTypes.start.getCharPositionInLine()+1
                                                                                                                    , new FuncType($funcTypes.start.getLine()
                                                                                                                                    , $funcTypes.start.getCharPositionInLine()+1
                                                                                                                                    , $funcTypes.ast
                                                                                                                                    , $parameters.ast)
                                                                                                                    , $ID.text
                                                                                                                    , $statements.ast));}
                                                                                    |varDefinition
                                                                                        {$ast.addAll($varDefinition.ast);}
                                                                                    ;

varDefinition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]     :type identifiers ';'
                                                                                        {for(String each : $identifiers.ast)
                                                                                            $ast.add(new VarDefinition($type.start.getLine()
                                                                                                                        , $type.start.getCharPositionInLine()+1
                                                                                                                        , $type.ast
                                                                                                                        , each));}
                                                                                         ;

identifiers returns [List<String> ast = new ArrayList<String>()]                    :ID','id=identifiers
                                                                                        {$ast.add($ID.text); $ast.addAll($id.ast);}
                                                                                    |ID
                                                                                        {$ast.add($ID.text);}
                                                                                    ;

statements returns [List<Statement> ast = new ArrayList<Statement>()]:  (varDefinition
                                                                            {$ast.addAll($varDefinition.ast);})*
                                                                        (statement
                                                                            {$ast.addAll($statement.ast);})*
                                                                     ;

definitions returns [List<Definition> ast = new ArrayList<Definition>()]: (definition
                                                                            {$ast.addAll($definition.ast);})*
                                                                        ;

expressions returns [List<Expression> ast = new ArrayList<Expression>()]            :expression','exs=expressions
                                                                                        {$ast.add($expression.ast); $ast.addAll($exs.ast);}
                                                                                    |expression
                                                                                        {$ast.add($expression.ast);}
                                                                                    ;

block returns [List<Statement> ast = new ArrayList<Statement>()]                    :'{'(statement
                                                                                        {$ast.addAll($statement.ast);})*'}'
                                                                                    |statement
                                                                                        {$ast.addAll($statement.ast);}
                                                                                    ;

funcTypes returns [Type ast]: builtinType
                                {$ast = $builtinType.ast;}
                            |v='void'
                                {$ast = new VoidType($v.getLine()
                                                , $v.getCharPositionInLine()+1);}
                            ;

parameters returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]               :type ID','p=parameters
                                                                                                {$ast.add(new VarDefinition($type.start.getLine()
                                                                                                            , $type.start.getCharPositionInLine()
                                                                                                            , $type.ast
                                                                                                            , $ID.text)); $ast.addAll($p.ast);}
                                                                                            |type ID
                                                                                                {$ast.add(new VarDefinition($type.start.getLine()
                                                                                                            , $type.start.getCharPositionInLine()
                                                                                                            , $type.ast
                                                                                                            , $ID.text));}
                                                                                            |
                                                                                            ;

records returns [List<RecordField> ast = new ArrayList<RecordField>()]                :(type identifiers ';'
                                                                                        {for (String each : $identifiers.ast)
                                                                                            $ast.add(new RecordField($type.start.getLine()
                                                                                                                    , $type.start.getCharPositionInLine()+1
                                                                                                                    , $type.ast
                                                                                                                    , each));})*
                                                                                    ;

main returns [FuncDefinition ast]: v='void' id='main' '('')' '{'statements'}'
                                    {$ast = new FuncDefinition($v.getLine()
                                                              , $v.getCharPositionInLine()+1
                                                              , new FuncType($v.getLine()
                                                                            , $v.getCharPositionInLine()+1
                                                                            , new VoidType($v.getLine()
                                                                                            , $v.getCharPositionInLine()+1))
                                                              , $id.text
                                                              , $statements.ast);}
                                 ;

fragment
LETTER                  : [a-zA-Z]
                        ;
fragment
DIGIT                   : [0-9]
                        ;
fragment
MANTISSA                :(INT_CONSTANT)'.'(DIGIT)*
                        |(INT_CONSTANT)?'.'(DIGIT)+
                        ;
fragment
EXPONENT                :('E'|'e')('+'|'-')?INT_CONSTANT
                        ;

INT_CONSTANT            : '0'
                        |[1-9][0-9]*
                        ;

ONE_LINE_COMMENT        : '//'.*?(EOF|'\n'|'\r') -> skip
                        ;

MULTIPLE_LINE_COMMENT   : '/*'.*?'*/' -> skip
                        ;

ID                      :('_'|LETTER)('_'|LETTER|DIGIT)*
                        ;

REAL_CONSTANT           :(INT_CONSTANT)(EXPONENT)
                        |(MANTISSA)(EXPONENT)?
                        ;

CHAR_CONSTANT           :'\''.'\''
                        |'\'''\\'('n'|'t'|INT_CONSTANT)'\''
                        ;

WS                      : ('\t'|'\n'|'\r'|' ') -> skip
                        ;