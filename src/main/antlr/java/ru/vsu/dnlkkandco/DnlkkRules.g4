grammar DnlkkRules;

program : stmt_list EOF;
stmt_list: stmt (stmt)*;
stmt_block : '{' stmt_list? '}';
stmt
    : definition #definition_stmt
    | assign #assign_stmt
    | expr #expr_stmt
    | if #if_stmt
    | while #while_stmt
    | for #for_stmt
    | return #return_stmt
    | GOTO #goto_stmt
    ;

// OPERATORS
if : IF '(' expr ')' stmt_block elif* else? ;
elif : ELIF '(' expr ')' stmt_block ;
else : ELSE stmt_block ;
while : WHILE '(' expr ')' stmt_block ;
for : FOR '(' definition? ';' logical? ';' assign? ')' stmt_block ;

return : RETURN expr ;

definition : VAR IDENT '=' (expr | fun) ;
assign : call '=' (expr | fun) ;

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
    : group #group_call
    | call '(' (expr (',' expr)*)? ')' #fun_call
    | call '.' IDENT #object_call
    | call '[' index=expr ']' #array_call
    ;
group
    : primitive #primitive_group
    | fun #fun_group
    | array_literal #array_literal_group
    | object_literal #object_literal_group
    | '(' expr ')' #expr_group
    ;

primitive
    : NULL
    | UNDEFINED
    | BOOL
    | NUM
    | DOUBLE
    | STRING_LITERAL
    | IDENT
    ;

// TYPES
fun : FUN fun_ident=IDENT? '(' (IDENT (',' IDENT)*)? ')' stmt_block ;
array_literal : '[' (array_element (',' array_element)*)? ']';
array_element : expr | fun;
STRING_LITERAL: '"' [a-zA-Z0-9 ,'!@#$%^&*()_+№;?=]* '"';
object_literal: '{' (field (',' field)*)? '}';
field: IDENT ':' (expr | fun);

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
VAR : 'var' ;

IDENT: (CHAR | '_')(CHAR | NUM | '_')* ;

// TYPES
CHAR : ([a-z] | [A-Z]) ;
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

WS : [ \t\r\n] -> channel(HIDDEN) ;
COMMENT : (START_COMMENT ' '* [a-zA-Z0-9 ]* END_COMMENT?) -> skip  ;