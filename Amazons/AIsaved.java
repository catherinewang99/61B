assert (sense == 1 || sense == -1);
        if (depth == 0 || board.winner() != null) {
            return staticScore(board);
        }
        Move bestmove = null;

        if (sense == 1) {
            int bestVal = Integer.MIN_VALUE;

            Iterator<Move> white_moves = board.legalMoves(WHITE);

            while (white_moves.hasNext()) {
                Move last_move = white_moves.next();
                board.makeMove(last_move);

                bestVal = Math.max(bestVal, findMove(board, depth - 1, saveMove,
                                                    -sense, alpha, beta));

                if (bestVal >= beta) {
                    break;
                }
                
               
                if (bestVal > alpha) {
                    alpha = Math.max(alpha, bestVal);
                    bestmove = last_move
                }
                
                board.undo();

            }

        } else {

            int bestVal = Integer.MAX_VALUE;

            Iterator<Move> black_moves = board.legalMoves(BLACK);

            while (black_moves.hasNext()) {
                Move last_move = black_moves.next();
                board.makeMove(last_move);
                bestVal = Math.min(bestVal, findMove(board, depth - 1, saveMove,
                                                    -sense, alpha, beta));

                if (bestVal <= alpha) {
                    break;
                }

                if (beta > bestmove) {
                    beta = Math.min(beta, bestmove);
                    bestmove = last_move;
                }

                board.undo();
            }
            
        }
        if (saveMove) {
                _lastFoundMove = bestmove;
            }
            return bestVal;
