package com.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DoorDemo {
	public static void main(String[] args) throws SQLException {
		System.out.println(permanentDoorNo(10371566899981224l));
		System.out.println(getAssessmentNo("1037"));
		
	}
	public synchronized static String permanentDoorNo(long uniqueReqNo) throws SQLException {
		return null;/*
		//Connection con = MySqlDBConnection.getEpayDB();
		//long l = 10371566899981224l;
		String Bno = null;
		String ewd = null;
		String loc = null;
		String ulb = null;
		PreparedStatement stmt = null;
		String Sql = "Select block,elecward,locality,ulbcode FROM ptassessmenttax.ptassessment_master where uniqueRequestNumber="
				+ uniqueReqNo + " and delflag='N'";

		//stmt = con.prepareStatement(Sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Bno = rs.getString("block");
			ewd = rs.getString("elecward");
			loc = rs.getString("locality");
			ulb = rs.getString("ulbcode");
		}
		String Sql3 = "update ptassessmenttax.count set DoorNoCount=DoorNoCount+1";
		stmt = con.prepareStatement(Sql3);
		stmt.executeUpdate();
		String sql4 = "SELECT DoorNoCount FROM ptassessmenttax.`count` c";
		stmt = con.prepareStatement(sql4);
		ResultSet rs2 = stmt.executeQuery();
		int i = 0;
		while (rs2.next()) {
			i = Integer.parseInt(rs2.getString("DoorNoCount"));
		}
		String doorcount = "";
		if (i > 0 && i <= 9) {
			doorcount = "00" + i;
		} else if (i > 9 && i <= 99) {
			doorcount = "0" + i;
		} else {
			doorcount = "" + i;
		}
		String distname = Dbcon.getULBName(ulb);
		Connection conn = Dbcon.getdbfromdist(distname);
		PreparedStatement stmt1 = null;
		String sql = "select a.I_BLCKNO,b.VC_LCTYNAME,c.I_RWNO from CT_BLCK_MSTR_TBL a ,CT_LCTY_MSTR_TBL b,CT_RW_MSTR_TBL c where a.I_BLCKOBJID="
				+ Bno
				+ " and a.I_ULBOBJID="
				+ ulb
				+ " and b.I_LCTYOBJID="
				+ loc + " and c.I_RWOBJID=" + ewd + "";

		stmt1 = conn.prepareStatement(sql);
		ResultSet rs1 = stmt1.executeQuery();
		String dno = "";
		while (rs1.next()) {
			String Block = rs1.getString("I_BLCKNO");
			String Locality = rs1.getString("VC_LCTYNAME");
			String rward = rs1.getString("I_RWNO");
			dno = Block.concat("-").concat(rward).concat("-")
					.concat(Locality.substring(0, 2).concat(doorcount));
		}
		return dno;
	*/}
	public synchronized static String getAssessmentNo(String ulb) throws SQLException{
		return ulb;/*
		String distname = Dbcon.getULBName(ulb);
		Connection conn = Dbcon.getdbfromdist(distname);
		PreparedStatement stmt1 = null;
		String sql = "select coalesce((max(i_asmtno)+1),0) as i_asmtno  from pt_asmt_mstr_tbl where  I_ULBOBJID ="+ulb;
		stmt1 = conn.prepareStatement(sql);
		ResultSet rs1 = stmt1.executeQuery();
		String i_asmtno="";
		while (rs1.next()) {
			i_asmtno = rs1.getString("i_asmtno");
	}
		return i_asmtno;
*/}
}

