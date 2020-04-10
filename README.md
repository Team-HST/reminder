# RE:Minder
Common Message Notification Service

## Main concepts
#### \#1. Ticket
- Message issued through **channel** at specified time
- Includes issuance forms such as immediate issuance and reservation issuance

#### \#2. Channel
- Message issuance group. 
- It consists of **publishers** of users belonging to the channel.

#### \3. Publisher
- Converting and issuing the ticket issued through the channel into the actual message format that the user will receive.

## Project structure
#### \# reminder-be
- RE:Minder Service Backend
- Spring Boot + JPA
- MySQL

#### \# reminder-fe
- RE:Minder Service Frontend
- Vue.js

## CI & CD
- Build with Jenkins
- Deploy with TOAST Deploy
