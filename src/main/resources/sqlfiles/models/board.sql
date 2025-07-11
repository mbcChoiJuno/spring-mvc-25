--------------------------------- 보드 (게시판)
CREATE SEQUENCE board_seq;
DROP SEQUENCE board_seq;

CREATE TABLE board_tbl (
	board_index			NUMBER(10, 0),
	board_child_count	NUMBER(5) DEFAULT 0,		-- 추가필요
	board_title			VARCHAR2(200),
	board_content		VARCHAR2(2000),
	board_view_count	NUMBER(10, 0) DEFAULT 0,
	board_create_date	DATE DEFAULT SYSDATE,
	board_update_date	DATE DEFAULT SYSDATE,
	deleted 			CHAR(1) DEFAULT 'N',		-- 추가필요
	
	user_id				VARCHAR2(50),
	PRIMARY KEY (board_index)
);
DROP TABLE board_tbl;

SELECT * FROM board_tbl;


ALTER TABLE board_tbl 
ADD deleted	CHAR(1) DEFAULT 'N';

ALTER TABLE board_tbl 
ADD board_child_count NUMBER(5) DEFAULT 0;




-- 1. 게시글 작성
INSERT INTO board_tbl (board_index, board_title, board_content, user_id) VALUES (board_seq.nextval, '게시글2', '게시글 내용2', 'junotest');
-- INSERT INTO board_tbl (board_index, board_title, board_content, user_id) VALUES (board_seq.nextval, ?, ?, ?)
INSERT INTO board_tbl (
	board_index, 
	board_title, 
	board_content, 
	user_id
) VALUES (
	board_seq.nextval, 
	'게시글2', 
	'게시글 내용2', 
	'junotest'
);

-- 2. 게시글 전체 조회 xxxxx
SELECT board_index, board_title , board_view_count, board_create_date, board_update_date, user_name FROM board_tbl B JOIN user_tbl U ON B.user_id = U.user_id;
-- SELECT board_index as boardIndex, board_title as title, board_view_count as viewCount, board_create_date as createDate, board_update_date as updateDate, user_name as writer FROM board_tbl B JOIN user_tbl U ON B.user_id = U.user_id
SELECT * FROM (
	SELECT 
		board_index as boardIndex, 
		board_title as title, 
		board_view_count as viewCount, 
		board_create_date as createDate, 
		board_update_date as updateDate, 
		user_name as writer 
		
	FROM board_tbl B JOIN user_tbl U 
		ON B.user_id = U.user_id
		
	WHERE
		deleted = 'N'
		
	ORDER BY 
		board_index DESC )
ORDER BY
	ROWNUM
	


-- 2. 게시글 전체 페이지 구하기
SELECT CEIL(COUNT(*) / 10) AS total_count
FROM board_tbl;

	


-- 3. 게시글 전체 조회 (페이징) 
SELECT * 
FROM (
    SELECT result.*, ROWNUM AS rn
    FROM (
        SELECT 
            board_index AS boardIndex,
            board_title AS title,
            board_view_count AS viewCount,
            board_create_date AS createDate,
            board_update_date AS updateDate,
            user_name AS writer
        FROM board_tbl B
        JOIN user_tbl U ON B.user_id = U.user_id
        WHERE deleted = 'N'
        ORDER BY board_index DESC
    ) result
    WHERE ROWNUM <= (4 * 10)  -- (1 * 10)
)
WHERE rn >= 1 + (3 * 10)  -- 1 + (0 * 10)









-- 4. 게시글 상세 조회  ++ 조회시  카운트+1
UPDATE board_tbl SET board_view_count = board_view_count + 1 WHERE board_index = 1;
SELECT board_index, board_title, board_content, board_view_count, board_create_date, board_update_date, user_name FROM board_tbl B JOIN user_tbl U ON B.user_id = U.user_id WHERE board_index = 1;


-- 5. 게시글 수정


-- 6. 게시글 삭제
DELETE FROM board_tbl WHERE board_index = 1;