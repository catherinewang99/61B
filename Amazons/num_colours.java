 public int num_white() {
        Iterator<Square> _startingSquares = Square.iterator();
        int counter = 0;
        while (_startingSquares.hasNext()) {
            Square next = _startingSquares.next();
            if (get(next) == WHITE) {
                counter++;
            }
        }
        return counter;
    }

    public int num_black() {
        Iterator<Square> _startingSquares = Square.iterator();
        int counter = 0;
        while (_startingSquares.hasNext()) {
            Square next = _startingSquares.next();
            if (get(next) == BLACK) {
                counter++;
            }
        }
        return counter;
    }