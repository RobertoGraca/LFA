grammar Frac;

program: stat* EOF;

stat: expr? ';'? NEWLINE	 		     #Expression
	| assignement? ';'? NEWLINE   	 #Variable
	| print? ';'? NEWLINE     		 #PrintFrac
	;
	
assignement: expr '->' ID; 

print: 'print' expr;

expr: op=('+'|'-') expr	         #ExprIntegerSignal
	| Integer '/' Integer		 #ExprFrac
	| expr op=('*'|':'|'%') expr #ExprMultDivMod
	| expr op=('+'|'-') expr     #ExprAddSub
	| Integer                    #ExprInteger
	| '(' expr ')'               #ExprParent
	| ID						 #ExprID
	;
	
Integer: [0-9]+;

NEWLINE: '\r'? '\n';

WS: [ \t]+ -> skip;

COMMENT: '//' .*? '\n' -> skip;

ID: [a-z]+;
	
	
