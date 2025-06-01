grammar XQL;

document: (instruction SPACE? (COMMENT | NEWLINE+))* instruction SPACE? (COMMENT | EOF);

instruction: (SPACE | NEWLINE)* (load | assign | save);

load   : LOAD SPACE ARGUMENT SPACE TO SPACE NAME;
assign : NAME SPACE EQUALS SPACE expression;
save   : SAVE SPACE NAME SPACE TO SPACE ARGUMENT;

expression: NAME composition? | TEMPLATE;

composition:
    DOT NAME composition?
    | ARROW NAME (SUM | COUNT | OFFSET)?
    | COUNT
    | OFFSET composition?
    | SUM
;

LOAD   : 'load';
TO     : 'to';
SAVE   : 'save';
EQUALS : '=';

COMMENT: '//' .*? (NEWLINE+ | EOF);

SPACE   : (' ' | '\t')+;
NEWLINE : '\n';

ARGUMENT : '$' [1-9]+;
NAME     : [a-zA-Z] [a-zA-Z0-9]*;

DOT      : '.';
ARROW    : '->';
COUNT    : '#';
OFFSET   : '[' [0-9]+ ']';
SUM      : '++';
TEMPLATE : '***' .*? '***';