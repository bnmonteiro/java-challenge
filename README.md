# java-challenge
Code of java challege for apple industries position

# Challenge 1
curl --location 'localhost:8080/reverse-sentence' \
--header 'Content-Type: text/plain' \
--data 'sentence to reverse words'

# Challenge 2
curl --location 'localhost:8080/prize-draw' \
--header 'Content-Type: application/json' \
--data '{
    "orderedPackage":"prints"
}'

# Challenge 3
curl --location 'localhost:8080/tax-owed' \
--header 'Content-Type: application/json' \
--data '{
    "boothId": 1,
    "month": 1,
    "year": 2023
}'
