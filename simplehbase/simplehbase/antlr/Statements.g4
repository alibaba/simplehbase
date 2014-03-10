grammar Statements;


prog:    selectc            # selectcl
       | countc             # countcl	   
	   | inserthqlc         # insertHqlCl
	   | selecthqlc         # selectHqlCl
	   | deletehqlc         # deleteHqlCl
       ;


inserthqlc : INSERT INTO tablename cidList VALUES constant2List ROWKEY IS rowkeyexp ( TS IS tsexp ) ? 
		   ;
		
selecthqlc : SELECT selectCidList FROM tablename ( wherec ) ? rowkeyrange ( maxversionexp) ?  (tsrange) ? (limitexp) ?
	       ;
	       
deletehqlc : DELETE selectCidList FROM tablename ( wherec ) ? rowkeyrange ( TS IS tsexp ) ?
	     ;	       

		   
selectc: SELECT wherec;
countc : COUNT wherec;

wherec: WHERE conditionc;

conditionc : LB conditionc RB              # conditionwrapper
	| conditionc AND conditionc            # andcondition
	| conditionc OR conditionc             # orcondition
	| cid EQUAL constant                   # equalconstant
	| cid EQUAL var                        # equalvar
	| cid LESS constant                    # lessconstant
	| cid LESS var                         # lessvar
	| cid GREATER constant                 # greaterconstant
	| cid GREATER var                      # greatervar
	| cid LESSEQUAL constant               # lessequalconstant
	| cid LESSEQUAL var                    # lessequalvar
	| cid GREATEREQUAL constant            # greaterequalconstant
	| cid GREATEREQUAL var                 # greaterequalvar
	| cid NOTEQUAL constant                # notequalconstant
	| cid NOTEQUAL var                     # notequalvar
	| cid NOTMATCH constant                # notmatchconstant
	| cid NOTMATCH var                     # notmatchvar
	| cid MATCH constant                   # matchconstant
	| cid MATCH var                        # matchvar
	| cid IN constantList                  # inconstantlist
	| cid IN var                           # invarlist
	| cid NOTIN constantList               # notinconstantlist
	| cid NOTIN var                        # notinvarlist
	| cid BETWEEN constant AND constant    # betweenconstant
	| cid BETWEEN var AND var              # betweenvar
	| cid NOTBETWEEN constant AND constant # notbetweenconstant
	| cid NOTBETWEEN var AND var           # notbetweenvar	
	| cid ISNULL                           # isnullc
	| cid ISNOTNULL                        # isnotnullc
	| cid ISMISSING                        # ismissingc
	| cid ISNOTMISSING                     # isnotmissingc
	;

rowkeyrange : ROWKEY RANGE LB rowkeyexp ',' rowkeyexp RB
			;

	
rowkeyexp : LB rowkeyexp RB                               # rowkey_Wrapper
	| funcname LB constant RB                         # rowkey_FuncConstant
	| STARTROWKEY                                     # rowkey_Start
	| ENDROWKEY                                       # rowkey_End
    ;

tsrange : TS RANGE LB tsexp ',' tsexp RB
	    ;
		
tsexp: constant ;

selectCidList : cidList   # cidList_CidList
			  | STAR      # cidList_Star
			  | TEXT      # cidList_Regx
	     	  ;
	
cidList : LB cid (',' cid) * RB ;
cid : TEXT ;

funcname: TEXT ;
	
constantList  : LB constant ( ',' constant) * RB ;
constant2List : LB constant2 ( ',' constant2) * RB ;

constant2: constant               # constant2_NotNull
         | NULL                   # constant2_Null
		 ;
		 
maxversionexp : MAXVERSION maxversion
			  ;
limitexp : LIMIT TEXT ( ',' TEXT)?
		 ;

tablename : TEXT ;	
maxversion : TEXT ;		 
constant: '"' TEXT '"';	
var : '#' TEXT '#' ;







STAR : '*' ;

LB : '(' ;
RB : ')' ;

WHERE : 'where' ;	

SELECT : 'select' ; 
COUNT : 'count' ;
INSERT : 'insert' ;
DELETE : 'delete' ;
INTO : 'into' ;
VALUES : 'values' ;
FROM : 'from' ;

ROWKEY : 'rowkey' ;
STARTROWKEY : 'startkey' ;
ENDROWKEY : 'endkey' ;
MAXVERSION : 'maxversion' ;
RANGE : 'range' ;
LIMIT : 'limit' ;


TS : 'ts' ;

IS : 'is' ;
NULL : 'null';
NOT : 'not';

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
  
TEXT :  [a-zA-Z0-9_:\<\(\[\{\\\^\-\=\$\!\|\]\}\)\?\*\+\.\>]+ ;

WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace