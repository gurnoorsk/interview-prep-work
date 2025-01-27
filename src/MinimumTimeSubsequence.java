import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumTimeSubsequence {
    public static long minTimeSubsequence(int[] arr, int n, int m) {

        long ans = Long.MAX_VALUE;
        int [] suffix = new int [n];
        int min =  Integer.MAX_VALUE;
        for(int i =n-1;i>=0;i--){
            min = Math.min(min,arr[i]);
            suffix[i] = min;
        }

        for(int i =0;i<n&&i+m-1<n;i++){
            ans = Math.min(ans,(long)arr[i] * suffix[i+m-1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10,10,3,4,5,6,8,10};
        int n = arr.length;
        int m = 4;

        long minTime = minTimeSubsequence(arr, n, m);
        System.out.println("Minimum time for subsequence of size " + m + ": " + minTime);


        //System.out.println(cipherDecrypt("279-527-476-768-768-377-257-172-663-97b-527-339-86e-564-468-576-96c-62a-321-162-56a-36d-96f-46d-265-376-97b-362-276-66f-966-46a-370-82a-832-47f-875-529-426-373-87d-567-66a-861-566-24b-676-321-73d-16f-772-468-36f-72b-220-87b-762-576-675-66f-46b-26c-940-662-725-933-624-86c-831-731-330-62b-83e-633-533-838-432-234-735-763-62b-87b-762-774-528-130-737-232-334-633-433-234-429-84e-36d-83a-751-84d-76d-743-95d-870-66b-54c-75f-252-431-36c-330-55c-540-749-56e-87f-572-334-33b-271-448-461-744-34c-97f-34a-765-142-44d-84a-67c-736-465-442-234-56d-471-452-445-178-546-154-562-353-156-852-87b-241-355-460-963-456-858-777-54b-44f-970-66c-768-673-669-859-769-475-541-24f-554-553-755-96b-83a-542-732-745-66c-27b-54d-274-766-652-277-546-24e-740-469-871-57d-862-250-760-830-83c-649-34e-471-364-355-64c-761-849-953-164-246-471-83b-86e-56f-276-254-54f-76e-924-332-134-838-931-426-824-527-97c-370-560-674-54b-263-26f-96c-82a-238-725-452-869-46d-86c-96c-36b-66f-323-743-96c-87b-869-168-32e-34b-648-44d-92b-22e-92b-764-26e-76e-560-56b-377-751-267-87a-774-861-46b-46a-123-53f-725-736-22c-737-22c-838-92b-529-321-277-477-461-97b-841-763-527-238-123-839-535-838-93e-633-433-432-92b-428-624-76b-160-87b-87c-448-867-760-16e-471-672-357-66f-865-663-321-339-938-136-333-332-336-637-135-839-436-734-233-431-536-62a-624-76b-766-774-87c-14d-16e-86f-36a-866-753-66f-26f-762-624-13b-233-334-636-332-93c-839-83b-831-334-839-634-83a-334-428-92b-564-87d-571-76f-555-46b-26e-76e-467-67f-355-271-85d-370-762-775-64f-967-86e-669-43e-667-471-470-46c-729-571-37a-474-560-22c-676-263-271-87b-97e-662-321-53f-426-972-65a-123-774-164-675-370-66f-56a-769-841-86c-559-220-43e-854-624-763-930-432-536-825-335-530-731-232-432-432-634-86c-825-172-461-97a-429-233-737-737-334-336-93e-432-528-741-668-537-650-144-56f-642-85c-77f-36e-148-65e-757-633-867-536-55c-441-749-863-374-671-334-73f-172-14d-461-546-847-670-940-96b-340-24b-547-47e-637-263-442-432-860-97c-553-948-37a-744-257-562-757-552-65c-271-546-355-165-268-351-353-272-846-249-47d-76d-46b-277-966-657-46a-677-84c-944-150-751-85a-664-436-443-83d-745-56f-27b-34b-375-564-85c-772-340-549-245-865-47d-77f-862-755-166-53d-632-34c-845-376-364-254-248-660-445-258-96c-743-772-231-264-56f-672-650-14b-36a-22f-130-530-333-830-25e-92b-529-15d-426-673-172-96c-775-54c-561-559-624-53f-65a-82a-332-333-939-83f-93c-631-630-458-725-824-15d-426-979-577-669-777-560-270-571-56c-267-172-75b-82a-13b-47f-25e-123-575-869-774-87b-671-46b-674-367-655-276-263-470-267-541-663-571-667-36a-569-458-123-13b-378-35f-725-173-164-564-675-867-16f-955-321-43e-866-772-864-468-22e-854-725-373-869-774-172-770-867-674-460-254-362-36f-26b-763-955-82a-43e-87c-173-673-366-62a-458-321-473-263-87a-56b-550-271-86d-674-458-220-73d-167-263-66a-87b-461-529-458-725-87b-46c-867-772-16d-662-241-56d-362-769-661-762-858-766-477-271-87f-46b-270-460-65a-426-238-86e-465-66a-774-560-37e-37e-22e-25e-527-16d-669-96e-26b-56b-959-270-36c-272-86d-87a-175-861-86d-271-458-123-238-47f-77a-77a-624-62a-426-667-277-377-961-252-669-468-26b-261-77e-452-576-85d-370-366-371-445-277-672-76f-457-470-968-377-762-123-63c-57e-875-22e-624-66a-867-364-26b-866-85c-26b-26f-560-624-73d-839-235-333-332-732-637-83c-334-138-138-334-332-332-529-321-665-864-46d-560-16f-87c-652-871-878-267-92b-63c-624-369-362-771-263-22c-277-861-22c-96a-468-960-267-56b-87c-92b-72b-321-775-86d-677-673-86d-97a-377-74e-266-426-238-321-233-734-336-86d-461-235-561-761-429-23a-536-361-630-825-531-665-531-361-429-260-634-63e-830-528-232-96f-331-634-664-630-437-839-334-83f-335-23b-82a-22e-82a-569-56a-96a-465-36f-44d-272-725-339-321-636-52b-232-12f-535-42a-636-426-62a-321-376-97a-560-270-357-67f-373-461-527-13b-624-441-37b-762-764-772-175-26b-472-461-321-428-624-96a-966-46a-276-667-467-470-84b-96c-46a-571-267-476-841-561-220-73d-736-12d-321-773-86d-371-964-56c-36d-766-965-54c-866-96f-36c-220-339-220-232-52b-838-826-939-22c-333-527-22e-92b-567-674-36c-97e-172-164-775-54c-769-462-16e-527-238-866-471-26e-76b-925-426-667-570-377-56d-560-967-97d-26b-467-667-276-76e-36c-967-555-768-36f-46d-86b-970-321-339-866-570-66a-468-27f"));

        //System.out.println(cipherDecrypt(args[0]));


        String inputString = "Hello World";

        Map<Character, Long> charCount = inputString.chars() // Get IntStream of characters
                .mapToObj(c -> (char) c) // Convert to Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Count occurrences
        charCount.forEach((character, count) -> System.out.print(character + ": " + count));


        Stack<String> stack = new Stack();
        Queue<String> queue = new LinkedList<>();

        System.out.println("");
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((Integer i,Integer j)-> j>i?1:-1);

        int [] arr1 = {1,2,3,4,5,6,7,9,10};
        int k = 4;
        for(int i :arr1){
//            if(pq.size() == k){
//                pq.remove();
//            }
            pq.add(i);
        }

        System.out.println(pq.toString());

    }




    public static String cipherDecrypt(String str) {

        str = str.replace("-", "");
        String result = "";
        for (int i = 0; i < str.length(); i += 3) {
            String hex = str.substring(i + 1, i + 3);
            result += (char)(Integer.parseInt(hex, 16) ^ (Integer.parseInt(String.valueOf(str.charAt(i)))));

                //System.out.println("partial + "+i+" : "+result);
        }



        return result;
    }
    

}
