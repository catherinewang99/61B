private int findMove(Board board, int depth, boolean saveMove, int sense,
                         int alpha, int beta) {

        assert (sense == 1 || sense == -1);
        if (depth == 0 || board.winner() != null) {
            return staticScore(board);
        }

        Move bestmove = null;
        int bestVal;
        if (sense == 1) {
            bestVal = Integer.MIN_VALUE;

            Iterator<Move> white_moves = board.legalMoves(WHITE);

            while (white_moves.hasNext()) {
                Move last_move = white_moves.next();
                board.makeMove(last_move);


                bestVal = Math.max(bestVal, findMove(board, depth - 1, false,
                        -sense, alpha, beta));
//                System.out.println("alpha: " + alpha);
//                System.out.println("beta: " + beta);

                if (alpha >= beta) {
                    break;
                }


                if (bestVal >= alpha) {
                    alpha = Math.max(alpha, bestVal);
                    bestmove = last_move;

                }
//                System.out.println("board before undo: " + board);
                board.undo();

            }

        } else {

            bestVal = Integer.MAX_VALUE;

            Iterator<Move> black_moves = board.legalMoves(BLACK);

            while (black_moves.hasNext()) {
                Move last_move = black_moves.next();
                board.makeMove(last_move);
                bestVal = Math.min(bestVal, findMove(board, depth - 1, false,
                        -sense, alpha, beta));

//                System.out.println("alpha: " + alpha);
//                System.out.println("beta: " + beta);

                if (beta <= alpha) {
                    break;

                }

                if (bestVal <= beta) {
                    beta = Math.min(beta, bestVal);
                    bestmove = last_move;

                }
                board.undo();

            }

        }
        if (saveMove) {
            _lastFoundMove = bestmove;
        }
        return bestVal;

    }
