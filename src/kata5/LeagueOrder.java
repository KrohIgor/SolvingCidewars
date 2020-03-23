package kata5;

class LeagueOrder {

    public static int[] computeRanks(int number, int[][] games) {
        int[][] teams = new int[number][6];
        /*
        team[numberTeam, point, scoring differential, goals scored, goals fell, position}
        */
        for (int i = 0; i < number; i++) {
            teams[i][0] = i;
        }
        for (int[] game : games) {
            boolean draw = false;
            boolean winFirstTeam = false;
            if (game[2] == game[3]) {
                draw = true;
            } else {
                if (game[2] > game[3]) {
                    winFirstTeam = true;
                }
            }
            if (draw) {
                teams[game[0]][1]++;
                teams[game[1]][1]++;
            } else {
                if (winFirstTeam) {
                    teams[game[0]][1] += 2;
                } else {
                    teams[game[1]][1] += 2;
                }
            }
            teams[game[0]][3] += game[2];
            teams[game[1]][3] += game[3];
            teams[game[0]][4] += game[3];
            teams[game[1]][4] += game[2];
            teams[game[0]][2] = teams[game[0]][3] - teams[game[0]][4];
            teams[game[1]][2] = teams[game[1]][3] - teams[game[1]][4];
        }
        for (int i = 0; i < teams.length; i++) {
            for (int j = 0; j < teams.length - 1; j++) {
                if (teams[j][1] < teams[j + 1][1] ||
                        (teams[j][1] == teams[j + 1][1] && teams[j][2] < teams[j + 1][2]) ||
                        (teams[j][1] == teams[j + 1][1] && teams[j][2] == teams[j + 1][2] && teams[j][3] < teams[j + 1][3])) {
                    int[] temp = teams[j];
                    teams[j] = teams[j + 1];
                    teams[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < teams.length; i++) {
            if ((i > 0) &&
                    (teams[i][1] == teams[i - 1][1] && teams[i][2] == teams[i - 1][2] && teams[i][3] == teams[i - 1][3])) {
                teams[i][5] = teams[i - 1][5];
            } else {
                teams[i][5] = i + 1;
            }
        }
        int[] result = new int[number];
        for (int[] team : teams) {
            result[team[0]] = team[5];
        }
        return result;
    }
}

