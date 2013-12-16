grammar Statements;

prog:   selectc ; 

selectc: SELECT wherec;

wherec: WHERE conditionc;

conditionc : '(' conditionc ')'        # wrapper
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
	;



	
cid : TEXT ;
constant: '"' TEXT '"';	
var : '#' TEXT '#' ;

WHERE : 'where' ;	

SELECT : 'select' ; 
COUNT : 'count' ;


AND : 'and' ;
OR : 'or' ;




LESSEQUAL : 'lessequal' ;
LESS : 'less' ;

GREATEREQUAL : 'greaterequal';
GREATER: 'greater' ;

EQUAL : 'equal' ;
NOTEQUAL : 'notequal' ;





   
TEXT :  [a-zA-Z0-9_.]+ ;

WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace