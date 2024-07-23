public class Decode {

    public static void decode(String str){
        str = str.replace("-", "");
        String result = "";
        for (int i = 0; i < str.length(); i += 3) {
            String hex = str.substring(i + 1, i + 3);
            result += (char)(Integer.parseInt(hex, 16) ^ (Integer.parseInt(String.valueOf(str.charAt(i)))));
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        decode("972-624-570-370-366-173-74e-86c-82a-63c-426-74a-277-569-571-861-340-84b-24f-968-668-564-760-366-577-624-72b-426-276-26d-46f-86d-26c-220-832-321-74a-174-66a-377-960-340-744-34e-667-56b-465-364-86d-674-82a-529-220-167-768-674-360-762-74b-46b-760-66f-36d-527-63c-365-160-66a-172-366-428-725-367-669-16c-766-36a-769-82a-73d-624-56c-76e-56c-377-376-667-470-332-826-362-36e-96c-77e-867-52b-56b-461-672-426-824-725-674-86d-574-87d-560-172-276-54c-763-82a-43e-967-772-864-468-32f-92b-878-577-46b-575-267-577-175-66f-461-576-527-53f-16f-570-76b-36f-824-321-960-675-645-465-474-175-96a-961-362-426-832-660-766-36f-97a-267-875");
        decode("378-82a-673-271-663-371-64f-86c-624-53f-82a-66b-961-535-534-857-465-367-66b-861-36d-92b-824-82a-87c-867-46f-762-26c-426-53f-527-342-460-76a-26b-56b-141-83c-134-83e-624-32f-321-563-867-775-764-267-34f-26d-86f-36a-668-527-43e-761-869-468-87b-366-824-426-763-966-568-869-66f-769-426-53f-725-36a-960-26b-377-277-263-672-839-927-465-568-461-47d-16e-52b-866-366-773-92b-925-527-97b-663-978-87d-663-774-571-940-460-321-53f-36d-97c-26e-569-62a-220-676-577-669-777-164-87a-672-66f-461-370-123-43e-769-570-76b-468-529-220-861-370-142-667-575-773-566-56d-465-725-832-365-263-965-675-86d-37e");
    }
}