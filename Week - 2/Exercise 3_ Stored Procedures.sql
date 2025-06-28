
--- Scenario 1: The bank needs to process monthly interest for all savings accounts.
CREATE TABLE SavingsAccounts (
   AccountID NUMBER PRIMARY KEY,
   CustomerID NUMBER,
   Balance NUMBER
);
INSERT INTO SavingsAccounts VALUES (1, 101, 5000);
INSERT INTO SavingsAccounts VALUES (2, 102, 10000);
INSERT INTO SavingsAccounts VALUES (3, 103, 7500);

COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
   FOR acct IN (SELECT AccountID, Balance FROM SavingsAccounts) LOOP
      UPDATE SavingsAccounts
      SET Balance = Balance + (Balance * 0.01)
      WHERE AccountID = acct.AccountID;
   END LOOP;
   
   COMMIT;
END;
/
BEGIN
   ProcessMonthlyInterest;
END;
/
SELECT * FROM SavingsAccounts;


--- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.

CREATE TABLE Employees (
   EmployeeID NUMBER PRIMARY KEY,
   EmployeeName VARCHAR2(100),
   DepartmentID NUMBER,
   Salary NUMBER
);

INSERT INTO Employees VALUES (1, 'Alice', 10, 50000);
INSERT INTO Employees VALUES (2, 'Bob', 10, 55000);
INSERT INTO Employees VALUES (3, 'Charlie', 20, 60000);

COMMIT;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
   p_DepartmentID IN NUMBER,
   p_BonusPercent IN NUMBER
) AS
BEGIN
   UPDATE Employees
   SET Salary = Salary + (Salary * p_BonusPercent / 100)
   WHERE DepartmentID = p_DepartmentID;
   
   COMMIT;
END;
/

BEGIN
   UpdateEmployeeBonus(10, 5);
END;
/
SELECT * FROM Employees;


--- Scenario 3: Transfer Funds Between Accounts

CREATE TABLE BankAccounts (
   AccountID NUMBER PRIMARY KEY,
   CustomerID NUMBER,
   Balance NUMBER
);

INSERT INTO BankAccounts VALUES (5, 201, 10000);
INSERT INTO BankAccounts VALUES (6, 202, 5000);

COMMIT;

CREATE OR REPLACE PROCEDURE TransferFunds (
   p_FromAccountID IN NUMBER,
   p_ToAccountID IN NUMBER,
   p_Amount IN NUMBER
) AS
   v_FromBalance NUMBER;
BEGIN
   
   SELECT Balance INTO v_FromBalance
   FROM BankAccounts
   WHERE AccountID = p_FromAccountID;

  
   IF v_FromBalance < p_Amount THEN
      RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
   END IF;

   
   UPDATE BankAccounts
   SET Balance = Balance - p_Amount
   WHERE AccountID = p_FromAccountID;

   
   UPDATE BankAccounts
   SET Balance = Balance + p_Amount
   WHERE AccountID = p_ToAccountID;

   COMMIT;
END;
/
BEGIN
   TransferFunds(1, 2, 2000);
END;
/

SELECT * FROM BankAccounts;

