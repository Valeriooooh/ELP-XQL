grammar XQL;

document: (instruction SPACE? comment? NEWLINE)* instruction SPACE? comment? EOF;

comment: COMMENT TEXT;

instruction: load | assign | save;

load: LOAD SPACE argument SPACE TO SPACE variable;
assign: variable SPACE EQUALS SPACE expression;
save: SAVE SPACE variable SPACE TO SPACE argument;

expression: variable composition? | TEMPLATE;
composition:
    DOT variable composition?
    | ARROW attribute
    | COUNT
    | OFFSET composition?
    | SUM
;

argument: ARGUMENT;
variable: NAME;
attribute: NAME;

LOAD: 'load';
TO: 'to';
SAVE: 'save';
EQUALS: '=';

SPACE: (' ' | '\t')+;
NEWLINE: '\n';
COMMENT: '//';
TEXT: ~[\n]+;

ARGUMENT: '$' [1-9];
NAME: [a-z] [a-zA-Z]*;

DOT: '.';
ARROW: '->';
COUNT: '#';
OFFSET: '[' [0-9] ']';
SUM: '++';
TEMPLATE: '***' .*? '***';