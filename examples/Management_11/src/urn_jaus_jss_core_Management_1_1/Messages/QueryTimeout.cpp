#include "urn_jaus_jss_core_Management_1_1/Messages/QueryTimeout.h"

namespace urn_jaus_jss_core_Management_1_1
{

void QueryTimeout::MsgHeader::HeaderRec::setParent(MsgHeader* parent)
{
	m_parent = parent;
}

void QueryTimeout::MsgHeader::HeaderRec::setParentPresenceVector()
{
	if(m_parent != NULL )
	{
		m_parent->setParentPresenceVector();
	}
}

jUnsignedShortInteger QueryTimeout::MsgHeader::HeaderRec::getMessageID()
{
	return m_MessageID;
}

int QueryTimeout::MsgHeader::HeaderRec::setMessageID(jUnsignedShortInteger value)
{
	m_MessageID = value;
	setParentPresenceVector();
	return 0;
}

/**
 * Returns the size of memory the used data members of the class occupies.
 * This is not necessarily the same size of memory the class actually occupies.
 * Eg. A union of an int and a double may occupy 8 bytes. However, if the data
 *     stored is an int, this function will return a size of 4 bytes.
 * 
 * @return
 */
const unsigned int QueryTimeout::MsgHeader::HeaderRec::getSize()
{
	unsigned int size = 0;
	
	size += sizeof(jUnsignedShortInteger);
	
	return size;
}

void QueryTimeout::MsgHeader::HeaderRec::encode(unsigned char *bytes)
{
	
	if (bytes == NULL)
	{
		return;
	}
	
	int pos = 0;
	jUnsignedShortInteger m_MessageIDTemp;
	
	m_MessageIDTemp = JSIDL_v_1_0::correctEndianness(m_MessageID);
	memcpy(bytes + pos, &m_MessageIDTemp, sizeof(jUnsignedShortInteger));
	pos += sizeof(jUnsignedShortInteger);
}

void QueryTimeout::MsgHeader::HeaderRec::decode(const unsigned char *bytes)
{
	
	if (bytes == NULL)
	{
		return;
	}
	
	int pos = 0;
	jUnsignedShortInteger m_MessageIDTemp;
	
	memcpy(&m_MessageIDTemp, bytes + pos, sizeof(jUnsignedShortInteger));
	m_MessageID = JSIDL_v_1_0::correctEndianness(m_MessageIDTemp);
	pos += sizeof(jUnsignedShortInteger);
}

QueryTimeout::MsgHeader::HeaderRec &QueryTimeout::MsgHeader::HeaderRec::operator=(const HeaderRec &value)
{
	m_MessageID = value.m_MessageID;
	
	return *this;
}

bool QueryTimeout::MsgHeader::HeaderRec::operator==(const HeaderRec &value) const
{
	if (m_MessageID != value.m_MessageID)
	{
		return false;
	}
	
	return true;
}

bool QueryTimeout::MsgHeader::HeaderRec::operator!=(const HeaderRec &value) const
{
	return !((*this) == value);
}

QueryTimeout::MsgHeader::HeaderRec::HeaderRec()
{
	m_parent = NULL;
	m_MessageID = 0x2003;
}

QueryTimeout::MsgHeader::HeaderRec::HeaderRec(const HeaderRec &value)
{
	/// Initiliaze the protected variables
	m_parent = NULL;
	m_MessageID = 0x2003;
	
	/// Copy the values
	m_MessageID = value.m_MessageID;
}

QueryTimeout::MsgHeader::HeaderRec::~HeaderRec()
{
}

QueryTimeout::MsgHeader::HeaderRec* const QueryTimeout::MsgHeader::getHeaderRec()
{
	return &m_HeaderRec;
}

int QueryTimeout::MsgHeader::setHeaderRec(const HeaderRec &value)
{
	m_HeaderRec = value;
	setParentPresenceVector();
	return 0;
}

void QueryTimeout::MsgHeader::setParentPresenceVector()
{
	// Nothing needed here, placeholder function
}

/**
 * Returns the size of memory the used data members of the class occupies.
 * This is not necessarily the same size of memory the class actually occupies.
 * Eg. A union of an int and a double may occupy 8 bytes. However, if the data
 *     stored is an int, this function will return a size of 4 bytes.
 * 
 * @return
 */
const unsigned int QueryTimeout::MsgHeader::getSize()
{
	unsigned int size = 0;
	
	size += m_HeaderRec.getSize();
	
	return size;
}

void QueryTimeout::MsgHeader::encode(unsigned char *bytes)
{
	
	if (bytes == NULL)
	{
		return;
	}
	
	int pos = 0;
	m_HeaderRec.encode(bytes + pos);
	pos += m_HeaderRec.getSize();
}

void QueryTimeout::MsgHeader::decode(const unsigned char *bytes)
{
	
	if (bytes == NULL)
	{
		return;
	}
	
	int pos = 0;
	m_HeaderRec.decode(bytes + pos);
	pos += m_HeaderRec.getSize();
}

QueryTimeout::MsgHeader &QueryTimeout::MsgHeader::operator=(const MsgHeader &value)
{
	m_HeaderRec = value.m_HeaderRec;
	m_HeaderRec.setParent(this);
	
	return *this;
}

bool QueryTimeout::MsgHeader::operator==(const MsgHeader &value) const
{
	if (m_HeaderRec != value.m_HeaderRec)
	{
		return false;
	}
	return true;
}

bool QueryTimeout::MsgHeader::operator!=(const MsgHeader &value) const
{
	return !((*this) == value);
}

QueryTimeout::MsgHeader::MsgHeader()
{
	m_HeaderRec.setParent(this);
	/// No Initialization of m_HeaderRec necessary.
}

QueryTimeout::MsgHeader::MsgHeader(const MsgHeader &value)
{
	/// Initiliaze the protected variables
	m_HeaderRec.setParent(this);
	/// No Initialization of m_HeaderRec necessary.
	
	/// Copy the values
	m_HeaderRec = value.m_HeaderRec;
	m_HeaderRec.setParent(this);
}

QueryTimeout::MsgHeader::~MsgHeader()
{
}

QueryTimeout::MsgHeader* const QueryTimeout::getMsgHeader()
{
	return &m_MsgHeader;
}

int QueryTimeout::setMsgHeader(const MsgHeader &value)
{
	m_MsgHeader = value;
	return 0;
}

/**
 * Returns the size of memory the used data members of the class occupies.
 * This is not necessarily the same size of memory the class actually occupies.
 * Eg. A union of an int and a double may occupy 8 bytes. However, if the data
 *     stored is an int, this function will return a size of 4 bytes.
 * 
 * @return
 */
const unsigned int QueryTimeout::getSize()
{
	unsigned int size = 0;
	
	size += m_MsgHeader.getSize();
	
	return size;
}

void QueryTimeout::encode(unsigned char *bytes)
{
	
	if (bytes == NULL)
	{
		return;
	}
	
	int pos = 0;
	m_MsgHeader.encode(bytes + pos);
	pos += m_MsgHeader.getSize();
}

void QueryTimeout::decode(const unsigned char *bytes)
{
	
	if (bytes == NULL)
	{
		return;
	}
	
	int pos = 0;
	m_MsgHeader.decode(bytes + pos);
	pos += m_MsgHeader.getSize();
}

QueryTimeout &QueryTimeout::operator=(const QueryTimeout &value)
{
	m_MsgHeader = value.m_MsgHeader;
	
	return *this;
}

bool QueryTimeout::operator==(const QueryTimeout &value) const
{
	if (m_MsgHeader != value.m_MsgHeader)
	{
		return false;
	}
	
	return true;
}

bool QueryTimeout::operator!=(const QueryTimeout &value) const
{
	return !((*this) == value);
}

QueryTimeout::QueryTimeout()
{
	/// No Initialization of m_MsgHeader necessary.
	m_IsCommand = false;
}

QueryTimeout::QueryTimeout(const QueryTimeout &value)
{
	/// Initiliaze the protected variables
	/// No Initialization of m_MsgHeader necessary.
	m_IsCommand = false;
	
	/// Copy the values
	m_MsgHeader = value.m_MsgHeader;
}

QueryTimeout::~QueryTimeout()
{
}


}
