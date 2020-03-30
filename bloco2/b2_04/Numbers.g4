grammar Numbers;

program: stat* EOF;

stat: expr? NEWLINE;

expr: Number '-' Write;

Number: [0-9]+;

Write: [A-Za-z]+; 

NEWLINE: '\r'? '\n';

WS: [ \t]+ -> skip;
