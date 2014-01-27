grammar Statements;


prog:    selectc           # selectcl
       | countc            # countcl
	   | insertc           # insertcl
       ;


insertc : INSERT INTO tablename cidList VALUES constantList ROWKEY IS rowkeyexp ( TS IS tsexp ) ? # insertconstantList
		;
	   
selectc: SELECT wherec;
countc: COUNT wherec;

wherec: WHERE conditionc;

conditionc : LB conditionc RB          # conditionwrapper
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
	| cid ISMISSING                        # ismissingc
	| cid ISNOTMISSING                     # isnotmissingc
	;

	
rowkeyexp : LB rowkeyexp RB        # rowkeywrapper
	| funcname LB rowkeyexp ( ',' rowkeyexp) * RB     # rowkeyfunc
	| funcname LB constant RB      # rowkeyfuncconstant
    ;

tsexp: constant ;
	
constantList : LB constant ( ',' constant) * RB ;
cidList : LB cid (',' cid) * RB ;

tablename : TEXT ;	
cid : TEXT ;

constant: '"' TEXT '"';	
var : '#' TEXT '#' ;

funcname: TEXT ;







LB : '(' ;
RB : ')' ;

WHERE : 'where' ;	

SELECT : 'select' ; 
COUNT : 'count' ;
INSERT : 'insert' ;
INTO : 'into' ;
VALUES : 'values' ;

ROWKEY : 'rowkey' ;
TS : 'ts' ;
IS : 'is' ;

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

ISMISSING : 'ismissing' ;
ISNOTMISSING : 'isnotmissing' ;
  
TEXT :  [a-zA-Z0-9_\<\(\[\{\\\^\-\=\$\!\|\]\}\)\?\*\+\.\>]+ ;

WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace