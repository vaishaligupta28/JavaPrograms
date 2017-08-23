class Deck
{	
	public Card[]deck;
   
	public Card[][] setOfCards;
	Deck()
	{
		deck = new Card[52];
	}

	//initialize the cards
	void initializeCards()
	{
		int k=0;
		for(int suit=0;suit<4;suit++)
		{
			for(int rank=1;rank<=13;rank++)
			{
				deck[k] = new Card(suit, rank);
				k++;
			}
		}
	}

	//swapping a random card with the selected card
	void shuffleCards()
	{
		for(int i=0;i<52;i++)
		{
			int rand = (int)(Math.random()*(i+1));
			Card tempCard = deck[i];
			deck[i] = deck[rand];
			deck[rand] = tempCard;
		}
	}

	void distributeCards()
	{
		int k=0;
		setOfCards = new Card[4][9];
		for(int player=0;player<4;player++)
		{
			for(int cards=0;cards<9;cards++)
			{
				setOfCards[player][cards] = deck[k++];//distributing cards serially
			}
		}
	}

	void displayCards()
	{
		for(int player=0;player<4;player++)
		{
			System.out.println("\nPlayer "+ (player+1) +":  ");
			for(int cards=0;cards<9;cards++)
			{
				Card card = setOfCards[player][cards];
				System.out.println("         "+toStringRank(card.rank) + " of " + toStringSuit(card.suit));
			}
		}
	}

	String toStringSuit(int suit)
	{
		switch(suit)
		{
			case 0:
			     return "Clubs";
			case 1:
			     return "Diamonds";
			case 2:
			     return "Hearts";
			case 3:
			     return "Spades";
		}
		return "";
	}
	String toStringRank(int rank)
	{
		switch(rank)
		{
			case 1:
			     return "Ace";
			case 2:
			     return "2";
			case 3:
			     return "3";
			case 4:
			     return "4";
			case 5:
			     return "5";
			case 6:
			     return "6";
			case 7:
			     return "7";
			case 8:
			     return "8";
			case 9:
			     return "9";
			case 10:
			     return "10";
			case 11:
			     return "Jack";
			case 12:
			     return "Queen";
			case 13:
			     return "King";
		}
		return "";
	}

	//swap method for integers
	public void swap(Card[] array, int i, int j) 
	{
		Card temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	Card[] sort(int row)
	{
		for(int i=0 ; i<(setOfCards[row].length - 1); i++)
		 {
		 	for(int j=0 ; j<(setOfCards[row].length - i - 1); j++)
		 	{
		 		if(setOfCards[row][j].rank>setOfCards[row][j+1].rank) /* For decreasing order use < */
		 		{
		 			swap(setOfCards[row], j, j+1);
        		}																												
        	 }
        }
        return setOfCards[row];
	}
}


class Card
{
	protected int suit;
	protected int rank;
	protected Card next;
	Card(int suit, int rank)
	{
		this.suit = suit;
		this.rank = rank;
		this.next = null;
	}
}


class Player
{
	Card front, rear;
	Player()
	{
		front = null;
		rear = null;
	}
	
	boolean isEmpty()
	{
		if(front ==  null)
			return true;
		return false;
	}

	void enqueue(Card newCard)
	{
		if(isEmpty())
		{
			front = newCard;
		}
		else
		{
			rear.next = newCard;
		}	
		rear = newCard;
	}

	void dequeue()
	{
		if(front == null){
			rear = null;
		}
		if(front.next == null){front = null;return;}
		front = front.next;
	}
}


class DeckOfCards
{
	public static void main(String args[])
	{
	    //program 9 logic		
		Deck objDeck = new Deck();
		objDeck.initializeCards();
		objDeck.shuffleCards();
		System.out.println("\nAfter shuffling and distribution of Cards");
		objDeck.distributeCards();
		objDeck.displayCards();

		//Program 10 logic
		System.out.println("\n\nAfter sorting and adding in Queue, the cards are as follows");
		Card cardArr[];
		Player player;
		for(int i=0;i<4;i++){
			System.out.println("\nPlayer "+(i+1)+": ");
			cardArr = objDeck.sort(i);

			//enqueing and dequeing and printting the player cards using queue
			player = new Player();
			for(Card card: cardArr)
			{
				player.enqueue(card);
			}

			//System.out.println(objDeck.toStringRank(player.front.rank) + " of "+ objDeck.toStringSuit(player.front.suit));
		
			for(int cards=0;cards<9;cards++)
			{
				System.out.println("         "+objDeck.toStringRank(player.front.rank) + " of "+ objDeck.toStringSuit(player.front.suit));
				player.dequeue();
			}
	  	}
	}
}