CREATE TABLE BankCust (
   CustomerID NUMBER PRIMARY KEY,
   CustomerName VARCHAR2(100),
   Age NUMBER,
   Balance NUMBER,
   IsVIP VARCHAR2(5)
);

CREATE TABLE BankLo (
   LoanID NUMBER PRIMARY KEY,
   CustomerID NUMBER,
   InterestRate NUMBER,
   DueDate DATE
);

INSERT INTO BankCust VALUES (10, 'John Doe', 72, 15000, 'FALSE');
INSERT INTO BankCust VALUES (20, 'Mary Smith', 55, 9500, 'FALSE');
INSERT INTO BankCust VALUES (30, 'Robert King', 66, 12000, 'FALSE');
INSERT INTO BankCust VALUES (40, 'Nancy Adams', 35, 4000, 'FALSE');

INSERT INTO BankLo VALUES (1001, 10, 7.0, SYSDATE + 15);
INSERT INTO BankLo VALUES (1002, 20, 8.5, SYSDATE + 45);
INSERT INTO BankLo VALUES (1003, 30, 6.0, SYSDATE + 25);
INSERT INTO BankLo VALUES (1004, 40, 9.2, SYSDATE + 5);

COMMIT;

-- Scenario 1: Apply 1% discount
BEGIN
   FOR cust IN (
      SELECT CustomerID
      FROM BankCust
      WHERE Age > 60
   ) LOOP
      UPDATE BankLo
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = cust.CustomerID;
   END LOOP;

   COMMIT;
END;
/
SELECT * FROM BankLo;


-- Scenario 2: Promote VIPs
BEGIN
   FOR cust IN (
      SELECT CustomerID, Balance
      FROM BankCust
   ) LOOP
      IF cust.Balance > 10000 THEN
         UPDATE BankCust
         SET IsVIP = 'TRUE'
         WHERE CustomerID = cust.CustomerID;
      END IF;
   END LOOP;

   COMMIT;
END;
/
SELECT * FROM Bankcust;

-- Scenario 3: Print reminders
DECLARE
   CURSOR due_loans_cur IS
      SELECT l.LoanID, l.CustomerID, c.CustomerName, l.DueDate
      FROM BankLo l
      JOIN BankCustomers c ON l.CustomerID = c.CustomerID
      WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
   FOR rec IN due_loans_cur LOOP
      DBMS_OUTPUT.PUT_LINE(
         'Reminder: Loan ' || rec.LoanID ||
         ' for customer ' || rec.CustomerName ||
         ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY')
      );
   END LOOP;
END;
/
SELECT * FROM BankLo;