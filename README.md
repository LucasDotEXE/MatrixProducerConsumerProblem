## General Problem summary:

      You get an int matrix (int[][]) of at least 2X2 theoretically going to ∞X∞, this represents a town.
      This matrix is filled with numbers that represent consumers or homes.
         - The number specifies the amount of resources.
         - The people in the homes are willing to travel up to 2 spaces, non diagonally.
         - The people in the homes can/cant walk through other houses.
      These consumers will need to be fed by producers or stores.
         - The stores will be represented by negative numbers.
         - The store provides X amount resources, represented by the negative number.
         - The store has to be in range of a home to provide to that home.

      Goals:
         - Find a distribution with the least amount of stores while feeding all homes.
         - Find a distribution with a given collection stores while feeding all homes, if none exists return null.

___
## Easy Problem summary:

- You get an int matrix (int[][]) of at least 2X2 theoretically going to ∞X∞, this represents a town.
- This matrix is filled with numbers that represent consumers or homes.
   - The number specifies the amount of resources. (always 1)
   - The people in the homes are willing to travel up to 2 spaces, non diagonally.
   - The people in the homes can walk through other houses.
- These consumers will need to be fed by producers or stores.
   - The stores will be represented by negative numbers.
   - The store provides 1 resource.
   - The store has to be in range of a home to provide to that home.

Goal is to find a distribution with the least amount of stores while feeding all homes.
___

## Medium Problem summary:

- You get an int matrix (int[][]) of at least 2X2 theoretically going to ∞X∞, this represents a town.
- This matrix is filled with numbers that represent consumers or homes.
  - The number specifies the amount of resources.
  - The people in the homes are willing to travel up to 2 spaces, non diagonally.
  - The people in the homes can walk through other houses.
- These consumers will need to be fed by producers or stores.
  - The stores will be represented by negative numbers.
  - The store provides X amount resources, represented by the negative number. (so its variable)
  - The store has to be in range of a home to provide to that home.

### Goals:
  - Find a distribution with the least amount of stores while feeding all homes.
  - Find a distribution with a given collection stores while feeding all homes, if none exists return null.
___

## Hard Problem summary:

- You get an int matrix (int[][]) of at least 2X2 theoretically going to ∞X∞, this represents a town.
- This matrix is filled with numbers that represent consumers or homes.
  - The number specifies the amount of resources.
  - The people in the homes are willing to travel up to X spaces, non diagonally. (so its variable)
  - The people in the homes cant walk through other houses.
- These consumers will need to be fed by producers or stores.
  - The stores will be represented by negative numbers.
  - The store provides X amount resources, represented by the negative number. (so its variable)
  - The store has to be in range of a home to provide to that home.

### Goals:
  - Find a distribution with the least amount of stores while feeding all homes.
  - Find a distribution with a given collection stores while feeding all homes, if none exists return null.
