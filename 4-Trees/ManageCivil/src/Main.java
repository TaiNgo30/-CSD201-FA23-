import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder();
        treeBuilder.buildTree("tinh.txt", "huyen.txt", "xa.txt", "dan.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập CCCD: ");
        String cccd = scanner.nextLine();

        Node citizenNode = treeBuilder.searchByCCCD(cccd);
        if (citizenNode != null) {
            Node xaNode = citizenNode.getParent();
            Node huyenNode = xaNode.getParent();
            Node tinhNode = huyenNode.getParent();

            System.out.println("Thông tin báo cáo:");
            System.out.println("Tỉnh: " + tinhNode.getName() + " (" + tinhNode.getCode() + ")");
            System.out.println("Huyện: " + huyenNode.getName() + " (" + huyenNode.getCode() + ")");
            System.out.println("Xã: " + xaNode.getName() + " (" + xaNode.getCode() + ")");
        } else {
            System.out.println("Không tìm thấy thông tin với CCCD đã nhập.");
        }
    }
}