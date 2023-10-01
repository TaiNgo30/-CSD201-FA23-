import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TreeBuilder {
    private static final int MAX_NODES = 1000;

    private Node[] tinhNodes = new Node[MAX_NODES];
    private Node[] huyenNodes = new Node[MAX_NODES];
    private Node[] xaNodes = new Node[MAX_NODES];
    private Node[] danNodes = new Node[MAX_NODES];
    private int tinhIndex = 0;
    private int huyenIndex = 0;
    private int xaIndex = 0;
    private int danIndex = 0;

    public void buildTree(String tinhFile, String huyenFile, String xaFile, String danFile) {
        try {
            loadTinhNodes(tinhFile);
            loadHuyenNodes(huyenFile);
            loadXaNodes(xaFile);
            loadDanNodes(danFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Node searchByCCCD(String cccd) {
        for (int i = 0; i < danIndex; i++) {
            if (danNodes[i].getCode().equals(cccd)) {
                return danNodes[i];
            }
        }
        return null;
    }

    private void loadTinhNodes(String tinhFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(tinhFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String code = parts[0].trim();
            String name = parts[1].trim();
            Node node = new Node(name, code, null);
            tinhNodes[tinhIndex++] = node;
        }
        reader.close();
    }

    private void loadHuyenNodes(String huyenFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(huyenFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String code = parts[0].trim();
            String tinhCode = parts[1].trim();
            String name = parts[2].trim();
            Node tinhNode = findNodeByCode(tinhCode, tinhNodes, tinhIndex);
            Node node = new Node(name, code, tinhNode);
            huyenNodes[huyenIndex++] = node;

            if (tinhNode != null) {
                tinhNode.addChild(node);
            }
        }
        reader.close();
    }

    private void loadXaNodes(String xaFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(xaFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String code = parts[0].trim();
            String huyenCode = parts[1].trim();
            String name = parts[2].trim();
            Node huyenNode = findNodeByCode(huyenCode, huyenNodes, huyenIndex);
            Node node = new Node(name, code, huyenNode);
            xaNodes[xaIndex++] = node;

            if (huyenNode != null) {
                huyenNode.addChild(node);
            }
        }
        reader.close();
    }

    private void loadDanNodes(String danFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(danFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String xaCode = parts[0].trim();
            String cccd = parts[1].trim();
            String name = parts[2].trim();
            Node xaNode = findNodeByCode(xaCode, xaNodes, xaIndex);
            Node node = new Node(name, cccd, xaNode);
            danNodes[danIndex++] = node;

            if (xaNode != null) {
                xaNode.addChild(node);
            }
        }
        reader.close();
    }
    private Node findNodeByCode(String code, Node[] nodes, int nodeCount) {
        for (int i = 0; i < nodeCount; i++) {
            if (nodes[i].getCode().equals(code)) {
                return nodes[i];
            }
        }
        return null;
    }
}