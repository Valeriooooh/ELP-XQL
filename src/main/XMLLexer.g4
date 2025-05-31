lexer grammar XMLLexer;

COMMENT : '<!--' .*? '-->';
CDATA   : '<![CDATA[' .*? ']]>';
DTD       : '<!' .*? '>' -> skip;
EntityRef : '&' Name ';';
CharRef   : '&#' DIGIT+ ';' | '&#x' HEXDIGIT+ ';';
SEA_WS    : (' ' | '\t' | '\r'? '\n')+;

OPEN         : '<'       -> pushMode(INSIDE);
XMLDeclOpen  : '<?xml' S -> pushMode(INSIDE);
SPECIAL_OPEN : '<?' Name -> more, pushMode(PROC_INSTR);

TEXT: ~[<&]+;

mode INSIDE;

CLOSE         : '>'  -> popMode;
SPECIAL_CLOSE : '?>' -> popMode;
SLASH_CLOSE   : '/>' -> popMode;
SLASH         : '/';
EQUALS        : '=';
STRING        : '"' ~[<"]* '"' | '\'' ~[<']* '\'';
Name          : NameStartChar NameChar*;
S             : [ \t\r\n] -> skip;

END: EOF -> skip;

fragment HEXDIGIT: [a-fA-F0-9];

fragment DIGIT: [0-9];

fragment NameChar:
    NameStartChar
    | '-'
    | '.'
    | DIGIT
    | '$'
;

fragment NameStartChar:
    [_:a-zA-Z]
;

mode PROC_INSTR;

PI     : '?>' -> popMode;
IGNORE : .    -> more;