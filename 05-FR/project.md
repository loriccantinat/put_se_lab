# Auction system

## Introduction

Specification of functional requirements as part of computerisation of the product sale process based on the auction mechanism.

## Business processes

---
<a id="bc1"></a>
### BC1: Auction sale

**Actors:** [Seller](#ac1), [Buyer](#ac2)

**Description:** Business process describing a sale by the auction mechanism.

**Main scenario:**
1. [Seller](#ac1) offers the product at an auction. ([UC1](#uc1))
2. [Buyer](#ac2) offers a bid for the product that is higher than the currently highest bid. ([BR1](#br1))
3. [Buyer](#ac2) wins the auction ([BR2](#br2))
4. [Buyer](#ac2) transfers the amount due to the Seller. ([UC4](#uc4))
5. [Seller](#ac1) transfers the product to the Buyer.([UC1](#uc6), ([UC1](#uc7))

**Alternative scenarios:** 

2.A. Buyer's bid has been outbid and [Buyer](#ac2) wants to outbid the current highest bid.
* 2.A.1. Continue at step 2.

3.A. Auction time has elapsed and [Buyer](#ac2) has lost the auction. ([BR2](#br2))
* 3.A.1. End of use case.

---

## Actors

<a id="ac1"></a>
### AC1: Seller

A person offering goods at an auction.

<a id="ac2"></a>
### AC2: Buyer

A person intending to purchase a product at an auction..


## User level use cases

### Actors and their goals 

[Seller](#ac1):
* [UC1](#uc1): Offering a product at an auction
* [UC4](#uc4): Confirming payement receipt
* [UC5]: Cancelling an auction
* [UC6]: Marking product as shipped

[Buyer](#ac2):
* [UC2](#uc2): Bidding for a product
* [UC3](#uc3): Browsing and searching for auctions
* [UC7]: Confirming product receipt
* [UC8]: Viewing bidding history

---
<a id="uc1"></a>
### UC1: Offering a product at an auction

**Actors:** [Seller](#ac1)

**Main scenario:**
1. [Seller](#ac1) reports to the system the willingness to offer the product up at an auction.
2. System asks for the product data and initial price.
3. [Seller](#ac1) provides product data and the initial price.
4. System verifies data correctness.
5. System informs that the product has been successfully put up for auction.

**Alternative scenarios:** 

4.A. Incorrect or incomplete product data has been entered.
* 4.A.1. informs about incorrectly entered data.
* 4.A.2. Continue at step 2.

---

<a id="uc2"></a>
### UC2: Bidding for a product

**Actors:** [Buyer](#ac2)

**Main scenario:**
1. [Buyer](#ac2) requests the system to display the current status of a specific auction.
2. System displays the product data, the current highest bid, the minimum required increment.
3. [Buyer](#ac2) submits a new bid amount.
4. System verifies that the bid complies with the bidding rule [BR1](#br1).
5. System records the bid as the new highest offer.
6. System confirms the [Buyer](#ac2) that the bid was placed well.

**Alternative scenarios:** 

4.A. The submitted bid is lower than or equal to the current highest bid + the minimum increment ([BR1](#br1)).
* 4.A.1. The system informs the [Buyer](#ac2) that the bid is too low.
* 4.A.2. The system show to the [Buyer](#ac2) the minimum required amount.
* 4.A.3. Continue at step 3.
  
3.A. The auction time has already elapsed [BR2](#br2)
* 3.A.1. The system informs the [Buyer](#ac2) that the action is closed.
* 3.A.3. End of use case.

---
<a id="uc3"></a>
### UC3: Browsing and searching for auctions

**Actors:** [Buyer](#ac2), [Seller](#ac1)

**Main scenario:**
1. Actor requests the system to display available auctions.
2. System retrieves all active auctions that have not allready elapsed.
3. System displays a list of auctions with details.
4. Actor enters a keyword or selects a category to filter the results.
5. System validates the search criteria.
6. System displays the filtered list of auctions to the Actor.

**Alternative scenarios:** 

5.A. No auctions match the entered keyword or category.
* 5.A.1. System informs the Actor that no results were found.
* 5.A.2. System offers to display all active auctions.
* 5.A.3. Continue at step 1.

---
<a id="uc4"></a>
### UC4: Confirming payment receipt

**Actors:** [Seller](#ac1)

**Main scenario:**
1. [Seller](#ac1) requests the system to display the list of auctions won by a [Buyer](#ac2) but not yet paid.
2. System displays the pending auctions including the final price and [Buyer](#ac2) details.
3. [Seller](#ac1) selects a specific auction and confirms that the payment has been received.
4. System verifies the status of the auction.
5. System updates the auction status to "Paid".
6. System notifies the [Buyer](#ac2) that the payment has been confirmed.

**Alternative scenarios:** 

3.A. [Seller](#ac1) reports that the payment has not been received after the agreed deadline.
* 3.A.1. System marks the transaction as "Payment Issue".
* 3.A.2. System notifies the [Buyer](#ac2) of the pending payment.
* 3.A.3. End of use case.

## Business objects (also known as domain or IT objects)

### BO1: Auction

The auction is a form of concluding a sale and purchase transaction in which the Seller specifies the starting bid of the product, while the Buyers may offer their own purchase offer, each time proposing a bid higher than the currently offered bid. The auction ends after a specified period of time. If at least one purchase offer has been submitted, the product is purchased by the Buyer who offered the highest bid. 

### BO2: Product

A physical or digital item to be auctioned.

## Business rules

<a id="br1"></a>
### BR1: Bidding at auction

Bidding at auction requires submitting an amount higher than current by a minimum of EUR 1.00

<a id="br2"></a>
### BR2: Winning an auction

Auction is won by [Buyer](#ac2) who submitted the highest bid before the end of the auction (time expires).


## CRUDL Matrix


| Use case                                  | Auction | Product | Bid |
| ----------------------------------------- | ------- | ------- | --- |
| UC1: Offering a product at an auction     |    C    |    C    |  -  |
| UC2: Bidding for a product                |    U    |    R    |  C  |
| UC3: Browsing/Searching                   |    L    |    L    |  R  |
| UC4: Confirming payment                   |    U    |    -    |  -  |
| UC5: Cancelling an auction                |    D    |    D    |  -  |
| UC6: Marking as shipped                   |    U    |    -    |  -  |
| UC7: Viewing bidding history              |    R    |    R    |  L  |
| UC8: Confirming receipt                   |    U    |    -    |  -  |




