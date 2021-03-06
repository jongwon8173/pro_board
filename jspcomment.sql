drop table jspcomment cascade constraints;

  CREATE TABLE "JAVA"."JSPCOMMENT" 
   (	"COM_NO" NUMBER NOT NULL ENABLE, 
	"COM_PNO" NUMBER NOT NULL ENABLE, 
	"POSTS_NO" NUMBER NOT NULL ENABLE, 
	"COM_CON" CLOB, 
	"COM_DT" DATE NOT NULL ENABLE, 
	"COM_WRI" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"COM_YN" CHAR(1 BYTE), 
	 CONSTRAINT "PK_JSPCOMMENT" PRIMARY KEY ("COM_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK_JSPPOSTS_TO_JSPCOMMENT" FOREIGN KEY ("POSTS_NO")
	  REFERENCES "JAVA"."JSPPOSTS" ("POSTS_NO") ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" 
 LOB ("COM_CON") STORE AS BASICFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING ) ;
 

   COMMENT ON COLUMN "JAVA"."JSPCOMMENT"."COM_NO" IS '댓글번호(ID)';
 
   COMMENT ON COLUMN "JAVA"."JSPCOMMENT"."COM_PNO" IS '상위댓글번호(ID)';
 
   COMMENT ON COLUMN "JAVA"."JSPCOMMENT"."POSTS_NO" IS '게시글번호(ID)';
 
   COMMENT ON COLUMN "JAVA"."JSPCOMMENT"."COM_CON" IS '댓글내용';
 
   COMMENT ON COLUMN "JAVA"."JSPCOMMENT"."COM_DT" IS '작성일시';
 
   COMMENT ON COLUMN "JAVA"."JSPCOMMENT"."COM_WRI" IS '작성자(학생번호ID)';
 
   COMMENT ON COLUMN "JAVA"."JSPCOMMENT"."COM_YN" IS '삭제여부';
 
   COMMENT ON TABLE "JAVA"."JSPCOMMENT"  IS '댓답글관리';
 