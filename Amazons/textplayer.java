String myMove() {
        while (true) {
            String line = _controller.readLine();
            if (line == null) {
                return "quit";
            } else if ((line.matches(MOVE_PATTERN)
                        && !board().isLegal(Move.mv(line)))
                        || (!line.matches("quit$")
                            && !line.matches("seed\\s+(\\d+)$")
                            && !line.matches("dump$")
                            && !line.matches("new$")
                            && !line.matches("auto\\s+(\\w+)$")
                            && !line.matches("manual\\s+(\\w+)$")
                            && !line.matches(MOVE_PATTERN))) {
                _controller.reportError("Invalid move. "
                        + "Please try again.");
                continue;
            } else if (board().winner() != null) {
                _controller.reportNote(board().winner() + " wins.");
            } else if (board().turn() != myPiece()){
                _controller.reportError("Incorrect turn.");
                continue;
            } else {
                return line;
            }
        }
    }