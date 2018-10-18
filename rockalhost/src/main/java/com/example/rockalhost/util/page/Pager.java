package com.example.rockalhost.util.page;

public class Pager {
	public static final int PAGE_SCALE = 10;//페이지당 게시물수(10개)
	public static final int BLOCK_SCALE = 10;//페이지 블럭 갯수
	private int curPage; //현재 페이지
	private int prevPage; //이전 페이지
	private int nextPage; //다음 페이지
	private int totPage; //전체 페이지 갯수
	private int totBlock; //전체 페이지블록 갯수
	private int curBlock; //현제 페이지블럭
	private int prevBlock; //이전 페이지블럭
	private int nextBlock; //다음 페이지블럭
	private int pageBegin; // #{start}에 전달될 값
	private int pageEnd; // #{end}에 전달될 값
	private int blockStart; //페이지블럭의 시작페이지 번호
	private int blockEnd; //페이지블럭의 끝페이지 번호
	
	public Pager(int count, int curPage){
		curBlock=1; //페이지블록을 1로 초기화
		this.curPage=curPage;
		setTotPage(count); //전체페이지 갯수 계산
		setPageRange(); //#{start}, #{end} 값 계산
		setTotBlock(); //페이지블럭의 갯수 계산
		setBlockRange(); //페이지블럭의 범위 설정
	}
	
	public void setBlockRange() {
		curBlock=(int)Math.ceil((curPage-1) / BLOCK_SCALE) + 1;

		blockStart=(curBlock-1) * BLOCK_SCALE + 1;
		blockEnd=blockStart + (BLOCK_SCALE - 1);

		if(blockEnd > totPage){
			blockEnd = totPage;
		}
		prevPage=curBlock==1 ? 1 : (curBlock-1) * BLOCK_SCALE;
		nextPage=curBlock>totBlock ? (curBlock*BLOCK_SCALE) : (curBlock*BLOCK_SCALE)+1;
		if(nextPage >= totPage){
			nextPage = totPage;
		}
	}

	public void setPageRange() {
		pageBegin = (curPage - 1) * PAGE_SCALE + 1;
		pageEnd = pageBegin + (PAGE_SCALE - 1);
	}


	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int count) {
		totPage = (int)Math.ceil(count * 1.0 / PAGE_SCALE);
	}
	public int getTotBlock() {
		return totBlock;
	}
	public void setTotBlock() {
		totBlock = (int)Math.ceil(totPage * 1.0 / BLOCK_SCALE);
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getBlockStart() {
		return blockStart;
	}
	public void setBlockStart(int blockStart) {
		this.blockStart = blockStart;
	}
	public int getBlockEnd() {
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}

}