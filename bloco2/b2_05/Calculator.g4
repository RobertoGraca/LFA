grammar Calculator;

program: stat* EOF;

stat: expr? NEWLINE			#Expression
	| assignement? NEWLINE  #Variable;

assignement: ID '=' expr;

expr: expr op=('*'|'/'|'%') expr #ExprMultDivMod
	| expr op=('+'|'-') expr     #ExprAddSub
	| Integer                    #ExprInteger
	| '(' expr ')'               #ExprParent
	| ID						 #ExprId
	| op=('+'|'-') expr			 #ExprIntegerSignal;
	
ID: [a-zA-Z]+;
	
Integer: [0-9]+;

NEWLINE: '\r'? '\n';

WS: [ \t]+ -> skip;

COMMENT: '#' .*? '\n' -> skip;
