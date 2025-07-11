--------------------------------- 보드 (게시판) 댓글, 대댓글
CREATE SEQUENCE board_seq;
DROP SEQUENCE board_seq;


CREATE TABLE board_comment_tbl (
	board_index				NUMBER(10, 0),
	comment_content			VARCHAR2(2000),
	comment_create_date		DATE DEFAULT SYSDATE,
	comment_update_date		DATE DEFAULT SYSDATE,
	--deleted					,			

	ref_board				NUMBER(10, 0),
	user_id					VARCHAR2(50),
	PRIMARY KEY (ref_board, board_index)
);
DROP TABLE board_comment_tbl;

SELECT * FROM board_comment_tbl;

ALTER TABLE board_comment_tbl 



-- 1. 댓글 작성 ( 내용, 글or댓글, 작성자 )
INSERT INTO board_comment_tbl (
	board_index,
	comment_content,
	ref_board,
	user_id
) VALUES (
	board_seq.nextval,
	'댓글1',
	1,
	'junotest'
);


-- 2. 댓글 목록 조회
SELECT 
	ROWNUM as cno, 
	comment_content as content, 
	comment_update_date as updateData,
	user_name as writer

FROM board_comment_tbl C JOIN user_tbl U 
	ON C.user_id = U.user_id

WHERE ref_board = 1;


-- 3. 댓글 수정



-- 4. 댓글 삭제






	board_index			NUMBER(10, 0),
	board_title			VARCHAR2(200),
	board_content		VARCHAR2(2000),
	board_view_count	NUMBER(10, 0) DEFAULT 0,
	board_create_date	DATE DEFAULT SYSDATE,
	board_update_date	DATE DEFAULT SYSDATE,
	user_id				VARCHAR2(50),
	PRIMARY KEY (board_index)
);