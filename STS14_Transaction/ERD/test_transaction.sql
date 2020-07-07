
/* Drop Tables */

DROP TABLE test_card CASCADE CONSTRAINTS;
DROP TABLE test_ticket CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_card
(
	user_id varchar2(20) NOT NULL,
	by_amount number DEFAULT 1
);


CREATE TABLE test_ticket
(
	user_id varchar2(20) NOT NULL,
	ticket_count number NOT NULL,
	CONSTRAINT ticket_buy_limit
	CHECK(ticket_count BETWEEN 1 AND 5)
);


-- ticket 2두장을 카드로 결제하는 경우--
INSERT INTO test_card values('aaa',2);
INSERT INTO TEST_TICKET values('aaa',2);
-- ticket 5두장을 카드로 결제하는 경우--
INSERT INTO test_card values('aaa',5);
INSERT INTO TEST_TICKET values('aaa',5);

SELECT * FROM TEST_CARD ;
SELECT * FROM TEST_TICKET ;


