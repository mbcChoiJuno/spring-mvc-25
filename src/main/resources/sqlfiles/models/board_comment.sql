--------------------------------- 보드 (게시판) 댓글, 대댓글
CREATE SEQUENCE board_seq;
DROP SEQUENCE board_seq;


CREATE TABLE board_comment_tbl (
	board_index				NUMBER(10, 0),
	board_child_count		NUMBER(5) DEFAULT 0,
	comment_content			VARCHAR2(2000),
	comment_create_date		DATE DEFAULT SYSDATE,
	comment_update_date		DATE DEFAULT SYSDATE,
	deleted					CHAR(1) DEFAULT 'N',	
	

	ref_board				NUMBER(10, 0),
	user_id					VARCHAR2(50),
	PRIMARY KEY (ref_board, board_index)
);
DROP TABLE board_comment_tbl;

SELECT * FROM board_comment_tbl;


ALTER TABLE board_comment_tbl 
ADD deleted	CHAR(1) DEFAULT 'N';

ALTER TABLE board_comment_tbl 
ADD board_child_count NUMBER(5) DEFAULT 0;



-- 1. 게시글에 댓글 작성 ( 내용, 글or댓글 id, 작성자 )
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
-- 게시글 child 카운트 증가
UPDATE board_tbl
SET
	board_child_count = board_child_count + 1
WHERE
	board_index = 1



-- 2. 댓글 목록 조회
SELECT 
	ROWNUM as cno, 
	comment_content as content, 
	comment_update_date as updateData,
	user_name as writer,
	board_index as boardIndex,
	deleted as deleted

FROM board_comment_tbl C JOIN user_tbl U 
	ON C.user_id = U.user_id

WHERE ref_board = 1;


-- 3. 댓글 수정
UPDATE board_comment_tbl 
SET 
	comment_content = '내용',
	comment_update_date = SYSDATE,
WHERE
	ref_board = 1 AND board_index = 61


-- 4. 댓글 삭제 (soft)
UPDATE board_comment_tbl 
SET 
	comment_update_date = SYSDATE,
	deleted = 'Y'
WHERE
	ref_board = 1 AND board_index = 61
	




