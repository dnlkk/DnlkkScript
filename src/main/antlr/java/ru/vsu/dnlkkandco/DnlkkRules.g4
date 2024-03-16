grammar DnlkkRules;

program : stmt_list ;
stmt_list : stmt* ;
stmt_block : '{' stmt_list '}' ;
stmt : definition | assign | expr | compare | if | while | for | fun | return | GOTO | fun_call;

// OPERATORS
if : 'if' '(' logical ')' stmt_block (('elif' '(' expr ')' stmt_block)* ('else' stmt_block)?)? ;
while : 'while' '(' logical ')' stmt_block? ;
for : 'for' '(' definition? ';' logical? ';' add? ')' stmt_block?;

return : 'return' expr;

fun : 'fun' IDENT? '(' args? ')' stmt_block;
args : IDENT (',' IDENT)* ;

fun_call : IDENT  '(' args_call? ')' ;
args_call : expr (',' expr)* ;


definition : 'var' assign ;
assign : IDENT '=' (expr | fun) ;

// BASE
expr : add | logical;
logical: (compare|not) (LOGICAL_OPERATORS (compare|not))*;
not: NOT_LOGICAL_OPERATOR (compare|not);
compare : add (COMPARE add)*;
add : mult (ADD mult)* ;
mult : group (MULT group)* ;
group : IDENT | NULL | UNDEFINED | BOOL | NUM | DOUBLE | '(' expr ')' | string_literal | fun_call;

// TYPES
string_literal: '"' STRING* '"';

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

WS : [ \t] -> skip ;
COMMENT : (START_COMMENT ' '* STRING* END_COMMENT?) -> skip  ;