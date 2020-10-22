if (_dir < 0) {
                _dir = 0;
            }
            int from_row = SIZE - _from.row() - 1;
            int from_col = SIZE - _from.col() - 1;

            if (_dir == 0) {
                if (_steps == from_row) {
                    _steps = 0;
                    _dir ++;
                    toNext();
                }
            } else if (_dir == 2) {
                if (_steps == from_col) {
                    _steps = 0;
                    _dir ++;
                    toNext();
                }
            } else if (_dir == 4) {
                if (_steps == SIZE - from_col) {
                    _steps = 0;
                    _dir ++;
                    toNext();
                }
            } else if (_dir == 6) {
                if (_steps == SIZE - from_row) {
                    _steps = 0;
                    _dir ++;
                    toNext();
                }
            } else if (_dir == 1) {
                if (_steps == min(from_col, from_row)) {
                    _steps = 0;
                    _dir ++;
                    toNext();
                }
            } else if (_dir == 3) {
                if (_steps == min(from_col, SIZE - from_row)) {
                    _steps = 0;
                    _dir ++;
                    toNext();
                }
            } else if (_dir == 5) {
                if (_steps == min(SIZE - from_col, SIZE - from_row)) {
                    _steps = 0;
                    _dir ++;
                    toNext();
                }
            } else if (_dir == 7) {
                if (_steps == min(SIZE - from_col, from_row)) {
                    _dir = 8;
                }
            }
