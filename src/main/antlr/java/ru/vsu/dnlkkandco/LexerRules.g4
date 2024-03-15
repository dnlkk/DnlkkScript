grammar LexerRules;

program : stmt_list ;
stmt_list : stmt* ;
stmt : assign | if | while | '{' stmt_list '}' ;

assign : ident '=' expr ;
if : 'if' '(' expr ')' stmt ;
while : 'while' '(' expr ')' stmt? ;

expr : add ;
add : mult (ADD mult)* ;
mult : group (MULT group)* ;
group : ident | NUM | '(' expr ')' ;
ident : IDENT;

KEYWORDS : ('if' | 'else' | 'while' | 'for') ;
IDENT : ('a'..'z'|'A'..'Z')+ ;
NUM : [0-9]+ ;
ADD : '+' | '-' ;
MULT : '*' | '/' ;
WS : [ \t] -> skip;