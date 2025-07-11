--------------------------------- 유저
CREATE TABLE user_tbl (
	user_id		VARCHAR(20),
	user_pw		VARCHAR(20),
	user_name	VARCHAR(20),
	PRIMARY KEY (user_id)
);
DROP TABLE user_tbl;

INSERT INTO user_tbl VALUES ('junotest', '1234', '최준오');


--------------------------------- 보드
CREATE SEQUENCE board_seq;
DROP SEQUENCE board_seq;

CREATE TABLE board_tbl (
	board_index			NUMBER(10, 0),
	board_title			VARCHAR2(200),
	board_content		VARCHAR2(2000),
	board_view_count	NUMBER(10, 0) DEFAULT 0,
	board_create_date	DATE DEFAULT SYSDATE,
	board_update_date	DATE DEFAULT SYSDATE,
	user_id				VARCHAR2(50),
	PRIMARY KEY (board_index)
);
DROP TABLE board_tbl;

SELECT * FROM board_tbl;





-- 1. 게시글 작성
INSERT INTO board_tbl (board_index, board_title, board_content, user_id) VALUES (board_seq.nextval, '게시글2', '게시글 내용2', 'junotest');
-- INSERT INTO board_tbl (board_index, board_title, board_content, user_id) VALUES (board_seq.nextval, ?, ?, ?)


-- 2. 게시글 전체 조회
SELECT board_index, board_title , board_view_count, board_create_date, board_update_date, user_name FROM board_tbl B JOIN user_tbl U ON B.user_id = U.user_id;
-- SELECT board_index as boardIndex, board_title as title, board_view_count as viewCount, board_create_date as createDate, board_update_date as updateDate, user_name as writer FROM board_tbl B JOIN user_tbl U ON B.user_id = U.user_id
SELECT board_index as boardIndex, board_title as title, board_view_count as viewCount, board_create_date as createDate, board_update_date as updateDate, user_name as writer FROM board_tbl B JOIN user_tbl U ON B.user_id = U.user_id;

-- 3. 게시글 전체 조회 (페이징)
SELECT board_index as boardIndex, 
	board_title as title, 
	board_view_count as viewCount, 
	board_create_date as createDate, 
	board_update_date as updateDate, 
	user_name as writer 
FROM board_tbl B JOIN user_tbl U 
	ON B.user_id = U.user_id
WHERE board_index BETWEEN (0 * 10) AND (1 * 10) 
ORDER BY board_index;

SELECT * FROM (
    SELECT 
        board_index AS boardIndex,
        board_title AS title,
        board_view_count AS viewCount,
        board_create_date AS createDate,
        board_update_date AS updateDate,
        user_name AS writer
    FROM (
        SELECT *
        FROM board_tbl B
        JOIN user_tbl U ON B.user_id = U.user_id
        ORDER BY board_index
    )
    WHERE ROWNUM <= 10
)
WHERE ROWNUM >= 1;









-- 4. 게시글 상세 조회  ++ 조회시  카운트+1
UPDATE board_tbl SET board_view_count = board_view_count + 1 WHERE board_index = 1;
SELECT board_index, board_title, board_content, board_view_count, board_create_date, board_update_date, user_name FROM board_tbl B JOIN user_tbl U ON B.user_id = U.user_id WHERE board_index = 1;


-- 5. 게시글 수정


-- 6. 게시글 삭제
DELETE TABLE board_tbl WHERE board_index = 1;