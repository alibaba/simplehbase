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
	;



	
cid : TEXT ;
constant: '"' TEXT '"';	
var : '#' TEXT '#' ;

WHERE : 'where' ;	

SELECT : 'select' ; 
COUNT : 'count' ;

AND : 'and' ;
OR : 'or' ;

EQUAL : 'equal' ;
LESS : 'less' ;
   
TEXT :  [a-zA-Z0-9_.]+ ;

WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace