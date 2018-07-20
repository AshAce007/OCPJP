package template.to.data.file.generation;

public class NodeIdentifier {
	private boolean iselement;
	private boolean isComplexType;
	private boolean isSequence;
	
	public NodeIdentifier(boolean iselement, boolean isComplexType, boolean isSequence) {
		super();
		this.iselement = iselement;
		this.isComplexType = isComplexType;
		this.isSequence = isSequence;
	}
	public boolean isIselement() {
		return iselement;
	}
	
	public boolean isComplexType() {
		return isComplexType;
	}
	
	public boolean isSequence() {
		return isSequence;
	}
}
