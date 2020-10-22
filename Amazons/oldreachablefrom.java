 /** An iterator used by reachableFrom. */
    private class ReachableFromIterator implements Iterator<Square> {

        /** Iterator of all squares reachable by queen move from FROM,
         *  treating ASEMPTY as empty. */
        ReachableFromIterator(Square from, Square asEmpty) {
            _from = from;
            _dir = 0;
            _steps = 0;
            _asEmpty = asEmpty;
            this.toNext();
        }

        @Override
        public boolean hasNext() {
            return _dir < 8;
        }

        @Override
        public Square next() {
            Square ret =  _from.queenMove(_dir, _steps); //REVISE
            this.toNext();
            return ret;
        }

        /** Advance _dir and _steps, so that the next valid Square is
         *  _steps steps in direction _dir from _from. */
        private void toNext() {
//            assert hasNext();
//            System.out.println("dir: " + _dir);

//            System.out.println("checking this dir and steps: " + _dir + " and " + (_steps + 1) + " from: " + _from);

            if (isUnblockedMove(_from, _from.queenMove(_dir, _steps + 1), _asEmpty)) { //Checks if next move in dir, steps is valid
//                System.out.println("is legal: " + _from.queenMove(_dir, _steps + 1));
                _steps++; // sets as empty so we dont forget that it is valid now

//            } else if (_from.queenMove(_dir, _steps + 1) == _asEmpty
//                        && _from.queenMove(_dir, _steps + 1) != null) {
//                _steps++;

            } else {
//                System.out.println("is illegal: " + _from.queenMove(_dir, _steps + 1));
                _dir++;
                _steps = 0;
                if (this.hasNext()) {
                    this.toNext();
                }
            }
        }

        /** Starting square. */
        private Square _from;
        /** Current direction. */
        private int _dir;
        /** Current distance. */
        private int _steps;
        /** Square treated as empty. */
        private Square _asEmpty;
    }