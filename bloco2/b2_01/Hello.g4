grammar Hello;
top : r+;
r : greetings | bye;
greetings : 'Hello' ID+;
bye : 'Bye' ID;
ID : [a-zA-Z0-9]+;
WS : [ \t\r\n]+ -> skip;
