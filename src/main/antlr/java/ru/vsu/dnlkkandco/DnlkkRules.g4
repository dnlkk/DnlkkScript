grammar DnlkkRules;

program : stmt_list? EOF;
stmt_list : stmt (EOL+ stmt)* EOL*;
stmt_block : EOL* '{' EOL* stmt_list EOL* '}' EOL*;
stmt
    : definition
    | assign
    | expr
    | if
    | while
    | for
    | fun
    | return
    | GOTO
    ;

// OPERATORS
if : IF '(' expr ')' stmt_block elif* else? ;
elif : ELIF '(' expr ')' stmt_block ;
else : ELSE stmt_block ;
while : WHILE '(' expr ')' stmt_block? ;
for : FOR '(' definition? ';' logical? ';' add? ')' stmt_block? ;

return : RETURN expr ;

fun : FUN IDENT? '(' args? ')' stmt_block ;
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
    | NOT_LOGICAL_OPERATOR not_operand=logical
    | left=logical LOGICAL_OPERATORS right=logical
    ;
compare
    : add
    | left=compare COMPARE right=compare
    ;
add
    : mult
    | left=add ADD right=add
    ;
mult
    : unary
    | left=mult MULT right=mult
    ;
unary
    : call
    | ADD unary_add_operand=unary
    | MULT unary_mult_operand=unary
    ;
call
    : group
    | object=call '.' IDENT
    | array=call '[' expr ']'
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
    | array_literal
    | object_literal
    | '(' expr ')'
    ;

// TYPES
STRING_LITERAL: '"' STRING* '"';
array_literal: '[' ((expr | fun) ','?)* ']';
object_literal: '{' (field ','?)* '}';
field: IDENT ':' (expr | fun);
//

IF: 'if' ;
ELIF : 'elif' ;
ELSE : 'else' ;
WHILE : 'while' ;
FOR : 'for' ;
RETURN : 'return' ;
FUN : 'fun' ;
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