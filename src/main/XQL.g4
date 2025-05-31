grammar XQL;

document: (instruction SPACE? (COMMENT | NEWLINE+))* instruction SPACE? (COMMENT | EOF);

instruction: (SPACE | NEWLINE)* (load | assign | save);

load   : LOAD SPACE ARGUMENT SPACE TO SPACE variable;
assign : variable SPACE EQUALS SPACE expression;
save   : SAVE SPACE variable SPACE TO SPACE ARGUMENT;

expression: variable composition? | TEMPLATE;

composition:
    DOT variable composition?
    | ARROW attribute SUM?
    | COUNT
    | OFFSET composition?
    | SUM
;

variable  : NAME;
attribute : NAME;

LOAD   : 'load';
TO     : 'to';
SAVE   : 'save';
EQUALS : '=';

COMMENT: '//' .*? (NEWLINE+ | EOF);

SPACE   : (' ' | '\t')+;
NEWLINE : '\n';

ARGUMENT : '$' [1-9];
NAME     : [a-z] [a-zA-Z]*;

DOT      : '.';
ARROW    : '->';
COUNT    : '#';
OFFSET   : '[' [0-9] ']';
SUM      : '++';
TEMPLATE : '***' .*? '***';