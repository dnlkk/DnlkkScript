grammar DnlkkRules;

program : stmt_list EOF;
stmt_list : (stmt EOL+)* ;
stmt_block : '{' stmt_list '}';
stmt
    : definition
    | assign
    | expr
    | compare
    | if
    | while
    | for
    | fun
    | return
    | GOTO
    ;

// OPERATORS
if : 'if' '(' logical ')' stmt_block ('elif' '(' expr ')' stmt_block)* ('else' stmt_block)? ;
while : 'while' '(' logical ')' stmt_block? ;
for : 'for' '(' definition? ';' logical? ';' add? ')' stmt_block?;

return : 'return' expr;

fun : 'fun' IDENT? '(' args? ')' stmt_block;
args : IDENT (',' IDENT)* ;

fun_call
    : IDENT
    | fun
    | fun_call '(' args_call? ')'
    ;
args_call : expr (',' expr)* ;


definition : 'var' assign ;
assign : IDENT '=' (expr | fun) ;

// BASE
expr : logical;
logical
    : compare
    | logical LOGICAL_OPERATORS compare
    ;
not
    : compare
    | NOT_LOGICAL_OPERATOR not
    ;
compare
    : add
    | compare COMPARE add
    ;
add
    : mult
    | add ADD mult
    ;
mult
    : unary
    | mult MULT unary
    ;
unary
    : group
    | ADD unary
    | MULT unary
    ;
group
    : NULL
    | UNDEFINED
    | BOOL
    | NUM
    | DOUBLE
    | STRING_LITERAL
    | IDENT
    | fun_call
//    | array_call
//    | object_call
    | array_literal
    | object_literal
    | '(' expr ')'
    ;
//group
//    : object_call
//    | primitive
//    ;
//primitive
//    : NULL
//    | UNDEFINED
//    | BOOL
//    | NUM
//    | DOUBLE
//    | STRING_LITERAL
//    ;
//object
//    : IDENT
//    | array_literal
//    | object_literal
//    | fun_call
//    | '(' expr ')'
//    ;

// TYPES
STRING_LITERAL: '"' STRING* '"';
array_literal: '[' ((expr | fun) ','?)* ']';
object_literal: '{' (field ','?)* '}';
field: IDENT ':' (expr | fun);
//

OPERATORS : ('if' | 'else' | 'while' | 'for' | 'fun') ;
GOTO : 'continue' | 'break' ;
LOGICAL_OPERATORS : 'or' | 'and' ;
NOT_LOGICAL_OPERATOR : 'not';

IDENT: (CHAR | '_')(CHAR | NUM | '_')* ;

// TYPES
CHAR : ([a-z] | [A-Z]) ;
STRING : (CHAR)+;
NUM : [0-9]+ ;
DOUBLE : [0-9]*[.][0-9]* ;
BOOL : 'false' | 'true' ;
NULL : 'null' ;
UNDEFINED : 'undefined' ;

START_COMMENT : '<--' ;
END_COMMENT : '-->' ;

// OPERATIONS
COMPARE : '>' | '<' | '>=' | '<=' | '==' | '!=' ;
ADD : '+' | '-' ;
MULT : '*' | '/' | '//' | '/%' ;

EOL : [\n] ;
WS : [ \t\r] -> skip ;
COMMENT : (START_COMMENT ' '* STRING* END_COMMENT?) -> skip  ;