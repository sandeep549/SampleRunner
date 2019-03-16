package com.example.misc.votting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Organize Online Election.
 * Keep voting for candidates, and query leading candidate at any time.
 * <p>
 * Can be used for 2 cases:
 * (1) When voting is online and we want to query leading candidate at any time.
 * (2) Feed voting and query winner at last.
 */
public class OnlineElection {

    /**
     * Map to store Candidate Id and his Vote object mapping.
     */
    private Map<Integer, Vote> candidateVoteMap = new HashMap<>();
    private TreeSet<Vote> leaderTreeMap = new TreeSet<>(new Comparator<Vote>() {
        @Override
        public int compare(Vote o1, Vote o2) {
            /**
             * (1) o2-o1 is to get max at top i.e. non increasing order
             * (2) -1 is to get priority for new element if count is equal
             */
            return o2.voteCount == o1.voteCount ? -1 : o2.voteCount - o1.voteCount;
        }
    });

    /**
     * Vode for Candidate Id
     *
     * @param candidate Candidate Id for which user want to vote
     *                  Time : O(logn) where n is no of candidates for which we have got votes.
     */
    public void vote(int candidate) {
        Vote vote = candidateVoteMap.get(candidate); // O(1)
        if (vote != null) {
            leaderTreeMap.remove(vote); // O(logn)
            vote.voteCount++;
            leaderTreeMap.add(vote); // O(logn)
        } else {
            Vote vote1 = new Vote(candidate, 1);
            candidateVoteMap.put(candidate, vote1); // O(1)
            leaderTreeMap.add(vote1); // O(logn)
        }
    }

    /**
     * Provide voting data at once.
     *
     * @param votes Array containing Candidate Id's for each vote.
     *              Time : O(M*logN) where M is total vote count, N is no of total candidates
     */
    public void votes(int[] votes) {
        for (int candidate : votes) vote(candidate);
    }

    /**
     * Get leader(i.e. projected winner) as of now.
     * Leader is the person who has top vote count now.
     *
     * @return Candidate Id of leader
     * Time : O(1)
     */
    public int seekLeader() {
        return leaderTreeMap.iterator().next().candidate;
    }

    /**
     * Stores Candidate and his vote count.
     */
    private class Vote {
        int candidate;
        int voteCount;

        public Vote(int candidate, int count) {
            this.candidate = candidate;
            this.voteCount = count;
        }
    }
}
