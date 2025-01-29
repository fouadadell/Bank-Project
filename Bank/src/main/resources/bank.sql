Create Table customer(
customer_id  SERIAL PRIMARY KEY ,
email VARCHAR(50) NOT NULL ,
mobile_number VARCHAR(11) NOT NULL,
pwd VARCHAR(300),
created_at DATE DEFAULT CURRENT_DATE
);
CREATE TABLE accounts(
account_id SERIAL PRIMARY KEY,
account_number VARCHAR(100) NOT NULL,
account_type VARCHAR(100),
created_at DATE DEFAULT CURRENT_DATE,
customer_id INTEGER NOT NULL,
FOREIGN KEY(customer_id) REFERENCES customer(customer_id)

);

Create Table authority(
authority_id SERIAL PRIMARY KEY,
authority_name VARCHAR(100) NOT NULL
) ;

CREATE TABLE Customer_authorities(
id SERIAL PRIMARY KEY,
authority_id int NOT NULL,
customer_id  int NOT NULL,
FOREIGN KEY(authority_id) REFERENCES authority(authority_id),
FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE branches(
branch_id SERIAL PRIMARY KEY,
branch_name VARCHAR(100 ) NOT NULL,
branch_address VARCHAR(100 ) NOT NULL,
account_id int NOT NULL ,
FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);

CREATE TABLE cards(
card_id SERIAL PRIMARY KEY,
card_number VARCHAR(100),
card_type VARCHAR(100),
total_limit INTEGER NOT NULL,
amount_used INTEGER NOT NULL,
available_amount INTEGER NOT NULL,
created_at DATE DEFAULT CURRENT_DATE,
customer_id INTEGER NOT NULL,
FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);
CREATE TABLE loans(
loan_id SERIAL PRIMARY KEY,
start_date DATE NOT NULL,
loan_type VARCHAR(100),
total_loan INTEGER DEFAULT 0,
amount_paid INTEGER DEFAULT 0 ,
outstanding_amount INTEGER DEFAULT 0 ,
created_at DATE DEFAULT CURRENT_DATE
);
CREATE TABLE customers_loans(
id SERIAL PRIMARY KEY ,
customer_id INTEGER NOT NULL,
loan_id INTEGER NOT NULL,
FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
FOREIGN KEY (loan_id) REFERENCES loans(loan_id)
);
CREATE TABLE transactions (
transaction_id SERIAL PRIMARY KEY,
transaction_date Date NOT NULL,
transaction_Summary VARCHAR(200),
transactionType VARCHAR(100),
transaction_amt INTEGER NOT NULL,
closing_balance INTEGER NOT NULL,
created_at DATE DEFAULT CURRENT_DATE,
account_id INTEGER NOT NULL,
customer_id INTEGER NOT NULL,
FOREIGN KEY (account_id)  REFERENCES accounts(account_id),
FOREIGN KEY (customer_id)  REFERENCES customer(customer_id)
);

ALTER TABLE branches
DROP COLUMN account_id;

ALTER TABLE accounts
ADD COLUMN branch_id INTEGER NOT NULL

ALTER TABLE accounts
ADD CONSTRAINT br_acc
FOREIGN KEY(branch_id) REFERENCES branches(branch_id);

ALTER TABLE transactions
Rename transactiontype TO transaction_type

INSERT INTO authority(authority_name)
VALUES('USER')

INSERT INTO authority(authority_name)
VALUES('ADMIN')

INSERT INTO loans (start_date, loan_type, total_loan, amount_paid, outstanding_amount, created_At)
 VALUES ( CURRENT_DATE, 'Home', 200000, 50000, 150000, CURRENT_DATE);

INSERT INTO loans (start_date, loan_type, total_loan, amount_paid, outstanding_amount, created_At)
 VALUES ( CURRENT_DATE, 'Vehicle', 40000, 10000, 30000, CURRENT_DATE);

INSERT INTO loans (start_date, loan_type, total_loan, amount_paid, outstanding_amount, created_At)
 VALUES ( CURRENT_DATE, 'Home', 50000, 10000, 40000, CURRENT_DATE);

INSERT INTO loans (start_date, loan_type, total_loan, amount_paid, outstanding_amount, created_At)
 VALUES ( CURRENT_DATE, 'Personal', 10000, 3500, 6500, CURRENT_DATE);

INSERT INTO branches(branch_name,branch_address)
VALUES('Haram','nazla el samman el sot w el do2')

INSERT INTO accounts (branch_id ,customer_id, account_number, account_type, created_at)
VALUES (1,1, 1865764534, 'Savings',  CURRENT_DATE);

INSERT INTO customer_authorities(authority_id,customer_id)
VALUES(1,1);


INSERT INTO transactions (customer_id,account_id,transaction_date,transaction_summary, transaction_type,transaction_amt,
closing_balance, created_at)
VALUES ( 1,1, CURRENT_DATE , 'Coffee Shop', 'Withdrawal',
30 , 34500,CURRENT_DATE);

Create Table contacts(
contact_id SERIAL PRIMARY KEY ,
contact_name VARCHAR(100) NOT NULL,
contact_email VARCHAR(100) NOT NULL,
contact_subject VARCHAR(100) NOT NULL,
contact_message VARCHAR(100) NOT NULL,
created_at DATE DEFAULT CURRENT_DATE
);