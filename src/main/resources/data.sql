-- insert into customer(name, email, password) values ('Tom Vu', 'tom.vu@rabobank.nl', 'tompassword');
-- insert into customer(id, name, email, password) values (2, 'John Smith', 'john.smith@example.com', 'johnpassword');
-- insert into account(id, customer, iban, balance) values (1, (select id from customer where email=''), 'NL01 INGB 1234 5678 90', 10000);
-- insert into account(id, customer, iban, balance) values (2, 1, 'NL01 INGB 1111 2222 33', 5000);
-- insert into account(id, customer, iban, balance) values (3, 2, 'NL02 INGB 0987 6543 21', 7000);
-- insert into account(id, customer, iban, balance) values (4, 2, 'NL02 INGB 9999 8888 77', 3000);
-- insert into transaction(id, account, senderIban, description, amount) values (1, 1, 'NL01 INGB 2222 3333 44', 'Rent', 1000);
