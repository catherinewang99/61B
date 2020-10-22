 /** An iterator used by legalMoves. */
    private class LegalMoveIterator implements Iterator<Move> {

        /** All legal moves for SIDE (WHITE or BLACK). */
        LegalMoveIterator(Piece side) {
            _startingSquares = Square.iterator();
            _spearThrows = NO_SQUARES;
            _pieceMoves = NO_SQUARES;
            _fromPiece = side;
            _numQueens = 0;
//            _start = _startingSquares.next();
            this.toNext();

        }

        @Override
        public boolean hasNext() {
//            System.out.println("hasnext() " + _spearThrows.hasNext() + _startingSquares.hasNext() + _pieceMoves.hasNext());
//            return _startingSquares.hasNext() && _numQueens < 5;

            return _startingSquares.hasNext() || _spearThrows.hasNext() || _pieceMoves.hasNext();
        }

        @Override
        public Move next() {
            Move ret = Move.mv(_start, _nextSquare, _spearThrows.next());
            this.toNext();
            return ret;
        }

        /** Advance so that the next valid Move is
         *  _start-_nextSquare(sp), where sp is the next value of
         *  _spearThrows. */
        private void toNext() {
//            assert hasNext();

            if (!this.hasNext()) {
                return;
            } else if (_spearThrows.hasNext()) {
                return;
            } else if (_pieceMoves.hasNext()) {
                _nextSquare = _pieceMoves.next();
                _spearThrows = reachableFrom(_nextSquare, _start);
            } else if (_startingSquares.hasNext()) {
                _start = _startingSquares.next();
                while (_startingSquares.hasNext()) {
                    if (get(_start) != _fromPiece) {
                        _start = _startingSquares.next();
                    } else {
                        _pieceMoves = reachableFrom(_start, null);
                        break;
                    }
                }
                toNext();
            }





//            if (_spearThrows == null || !_spearThrows.hasNext()) {
//
//                if ( _pieceMoves == null || !_pieceMoves.hasNext() ) {
//
//                    _start = _startingSquares.next();
////
//                    while (_startingSquares.hasNext()) {
//
//                        if (get(_start) != _fromPiece) {
//                            _start = _startingSquares.next();
//                        } else {
//                            _pieceMoves = reachableFrom(_start, null);
//                            break;
//                        }
//                    }
//                    _numQueens++;
//
//                }
//
//                _nextSquare = _pieceMoves.next();
//
//                _spearThrows = reachableFrom(_nextSquare, _start);
//
//            }
//
////            _nextSpear = _spearThrows.next();
        }

        /** Color of side whose moves we are iterating. */
        private Piece _fromPiece;
        /** Current starting square. */
        private Square _start;
        /** Remaining starting squares to consider. */
        private Iterator<Square> _startingSquares;
        /** Current piece's new position. */
        private Square _nextSquare;
        /** Remaining moves from _start to consider. */
        private Iterator<Square> _pieceMoves;
        /** Remaining spear throws from _piece to consider. */
        private Iterator<Square> _spearThrows;
        /** Throw spear here. */
        private Square _nextSpear;
        /** Checks if all pieces found. */
        private boolean _allQueens;
        /** Keeps track of Queens found. */
        private int _numQueens;
    }