package com.tech314.DDDataService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="campaign")
public class Campaign {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="DNDCamp")
	@SequenceGenerator(name="DNDCamp",sequenceName="DNDCamp_seq",allocationSize=1)
	@Column(name="campaign_id")
	private Integer campaignId;
	
	@Column(name="campaign_name")
	private String campaignName;
	
	@Column(name="campaign_pass")
	private String campaignPass;
	
	@Column(name="dm_id")
	private Integer dm_id;
	
	@Column(name="char1")
	private Integer char1;
	
	@Column(name="char2")
	private Integer char2;
	
	@Column(name="char3")
	private Integer char3;
	
	@Column(name="char4")
	private Integer char4;
	
	@Column(name="char5")
	private Integer char5;
	
	@Column(name="char6")
	private Integer char6;
	
	public Campaign() {}

	public Campaign(Integer campaignId, String campaignName, String campaignPass, Integer char1, Integer char2, Integer char3,
			Integer char4, Integer char5, Integer char6) {
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.campaignPass = campaignPass;
		this.char1 = char1;
		this.char2 = char2;
		this.char3 = char3;
		this.char4 = char4;
		this.char5 = char5;
		this.char6 = char6;
	}

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignPass() {
		return campaignPass;
	}

	public void setCampaignPass(String campaignPass) {
		this.campaignPass = campaignPass;
	}

	public Integer getChar1() {
		return char1;
	}

	public void setChar1(Integer char1) {
		this.char1 = char1;
	}

	public Integer getChar2() {
		return char2;
	}

	public void setChar2(Integer char2) {
		this.char2 = char2;
	}

	public Integer getChar3() {
		return char3;
	}

	public void setChar3(Integer char3) {
		this.char3 = char3;
	}

	public Integer getChar4() {
		return char4;
	}

	public void setChar4(Integer char4) {
		this.char4 = char4;
	}

	public Integer getChar5() {
		return char5;
	}

	public void setChar5(Integer char5) {
		this.char5 = char5;
	}

	public Integer getChar6() {
		return char6;
	}

	public void setChar6(Integer char6) {
		this.char6 = char6;
	}

	@Override
	public String toString() {
		return "Campaign [campaignId=" + campaignId + ", campaignName=" + campaignName + ", campaignPass="
				+ campaignPass + ", char1=" + char1 + ", char2=" + char2 + ", char3=" + char3 + ", char4=" + char4
				+ ", char5=" + char5 + ", char6=" + char6 + "]";
	}
}
