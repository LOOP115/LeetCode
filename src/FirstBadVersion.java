//public class FirstBadVersion {
//
//    public int firstBadVersion(int n) {
//        int low = 1;
//        int high = n;
//        while (low <= high) {
//            int mid = (high + low) >>> 1;
//            if (isBadVersion(mid)) {
//                // Search earlier version
//                high = mid - 1;
//            } else {
//                // Search later version
//                low = mid + 1;
//            }
//        }
//        return low;
//    }
//
//}
