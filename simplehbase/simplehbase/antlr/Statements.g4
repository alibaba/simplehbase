grammar Statements;


prog:    selectc           # selectcl
       | countc            # countcl
       ;


selectc: SELECT wherec;
countc: COUNT wherec;


wherec: WHERE conditionc;


conditionc : LB conditionc RB        # wrapper
	| conditionc AND conditionc        # andcondition
	| conditionc OR conditionc         # orcondition
	| cid EQUAL constant               # equalconstant
	| cid EQUAL var                    # equalvar
	| cid LESS constant                # lessconstant
	| cid LESS var                     # lessvar
	| cid GREATER constant             # greaterconstant
	| cid GREATER var                  # greatervar
	| cid LESSEQUAL constant           # lessequalconstant
	| cid LESSEQUAL var                # lessequalvar
	| cid GREATEREQUAL constant        # greaterequalconstant
	| cid GREATEREQUAL var             # greaterequalvar
	| cid NOTEQUAL constant            # notequalconstant
	| cid NOTEQUAL var                 # notequalvar
	| cid NOTMATCH constant            # notmatchconstant
	| cid NOTMATCH var                 # notmatchvar
	| cid MATCH constant               # matchconstant
	| cid MATCH var                    # matchvar
	| cid IN constantList              # inconstantlist
	| cid IN var                       # invarlist
	| cid NOTIN constantList           # notinconstantlist
	| cid NOTIN var                    # notinvarlist
	| cid BETWEEN constant AND constant # betweenconstant
	| cid BETWEEN var AND var           # betweenvar
	| cid NOTBETWEEN constant AND constant # notbetweenconstant
	| cid NOTBETWEEN var AND var           # notbetweenvar	
	| cid ISNULL                           # isnullc
	| cid ISNOTNULL                        # isnotnullc
	;

constantList : LB constant ( ',' constant) * RB ;

	
cid : TEXT ;
constant: '"' TEXT '"';	
var : '#' TEXT '#' ;

LB : '(' ;
RB : ')' ;

WHERE : 'where' ;	

SELECT : 'select' ; 
COUNT : 'count' ;


AND : 'and' ;
OR : 'or' ;




LESSEQUAL : 'lessequal' ;
LESS : 'less' ;

GREATEREQUAL : 'greaterequal';
GREATER: 'greater' ;

NOTEQUAL : 'notequal' ;
EQUAL : 'equal' ;


NOTMATCH : 'notmatch' ;
MATCH : 'match' ;

IN : 'in' ;
NOTIN : 'notin' ;

BETWEEN : 'between' ;
NOTBETWEEN : 'notbetween' ;

ISNULL : 'isnull' ;
ISNOTNULL : 'isnotnull' ;

  
TEXT :  [a-zA-Z0-9_\<\(\[\{\\\^\-\=\$\!\|\]\}\)\?\*\+\.\>]+ ;

WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace